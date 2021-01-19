package org.thing.in.spring.v1.ratelimiter.alg;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.curator.shaded.com.google.common.base.Stopwatch;

/**
 * desc 这个类是限流算法实现类。<p>
 * 它实现了最简单的固定时间窗口限流算法。<p>
 * 每个接口都要在内存中对应一个 RateLimitAlg 对象，<p>
 * 记录在当前时间窗口内已经被访问的次数。<p>
 * @author Sailor-why
 */
public class RateLimitAlg {

	private static final long TRY_LOCK_TIMEOUT = 200L;
	private Stopwatch stopwatch;
	private AtomicInteger currentCount = new AtomicInteger(0);
	private final int limit;
	private Lock lock = new ReentrantLock();
	
	public RateLimitAlg(int limit) {
		this(limit, Stopwatch.createStarted());  
	}

	protected RateLimitAlg(int limit, Stopwatch stopwatch) {    
		this.limit = limit;    
		this.stopwatch = stopwatch;   
	}
	public boolean tryAcquire() throws RuntimeException{
		int updatedCount = currentCount.incrementAndGet();
		if(updatedCount <= limit) {
			return true;
		}
		try {
			if(lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
				try {
					if(stopwatch.elapsed(TimeUnit.MILLISECONDS) > TimeUnit.SECONDS.toMillis(1)) {
						currentCount.set(0);
						stopwatch.reset();
					}
					updatedCount = currentCount.getAndIncrement();
					return updatedCount <= limit;
				} finally {
					lock.unlock();
				}
			}else {
				throw new RuntimeException("tryAcquire 方法 锁时间太长 超过："+TRY_LOCK_TIMEOUT +"/ms");
			}
		} catch (Exception e) {
			throw new RuntimeException("tryAcquire() is interrupted by lock-time-out.", e);
		}
	}

}
