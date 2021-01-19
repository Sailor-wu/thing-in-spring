package org.thing.in.spring.v2.ratelimiter.alg.impl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.thing.in.spring.v2.ratelimiter.alg.RateLimiter;
import org.thing.in.spring.v2.ratelimiter.exception.InternalErrorException;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;

/**
 * desc 这个类实现了固定时间窗口速率限制算法。 这个类是线程安全的
 * 
 * @author Sailor-why
 */
public class FixedTimeWindowRateLimiter implements RateLimiter {

	/* 超时时间 {@code Lock.tryLock() }. */
	private static final long TRY_LOCK_TIMEOUT = 200L; // 200ms.

	private Stopwatch stopwatch;

	private AtomicInteger currentCount = new AtomicInteger(0);

	/* 每秒允许的最大访问数 */
	private final int limit;

	private Lock lock = new ReentrantLock();

	public FixedTimeWindowRateLimiter(int limit) {
		// Creates (and starts) a new stopwatch using System.nanoTime as its time source
		this(limit, Stopwatch.createStarted());
	}

	@VisibleForTesting
	public FixedTimeWindowRateLimiter(int limit, Stopwatch stopwatch) {
		this.limit = limit;
		this.stopwatch = stopwatch;
	}

	@Override
	public boolean tryAcquire() throws InternalErrorException {
		// 
		System.out.printf("TimeUnit.SECONDS.toMillis(1):%d \n,stopwatch.elapsed(TimeUnit.MILLISECONDS):%s",TimeUnit.SECONDS.toMillis(1),stopwatch.elapsed(TimeUnit.MILLISECONDS));
		int updatedCount = currentCount.incrementAndGet();
		if (updatedCount <= limit) {
			return true;
		}
		try {
			// 尝试一定的时间内获取锁
			if(lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
				try {
					if(stopwatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)) {
						currentCount.set(0);
						stopwatch.reset();
					}
					updatedCount = currentCount.incrementAndGet();
					return updatedCount <= limit;
				} finally {
					lock.unlock();// 无论如何，都要释放锁
				}
			}else {
				throw new InternalErrorException(this.getClass().getName()+":tryAcquire() 等待时常过长 ："+TRY_LOCK_TIMEOUT+"/ms");
			}
		} catch (InterruptedException e) {
			throw new InternalErrorException(this.getClass().getName()+":tryAcquire() 锁超时中断。", e);
		}
	}

}
