package org.thing.in.spring.v2.ratelimiter.alg;

import org.thing.in.spring.v2.ratelimiter.exception.InternalErrorException;

/**
 * desc 算法实现接口
 * @author Sailor-why
 */
public interface RateLimiter {
	/**
	 * 	尝试获取访问令牌。
	 * @return 如果成功获得访问令牌，则返回true，否则返回false。
	 * @throws InternalErrorException:自定义内部错误.
	 */
	boolean tryAcquire() throws InternalErrorException;
}
