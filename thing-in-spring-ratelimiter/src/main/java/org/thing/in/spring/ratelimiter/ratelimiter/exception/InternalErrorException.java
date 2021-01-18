package org.thing.in.spring.ratelimiter.ratelimiter.exception;
/**
 * desc 自定义异常类信息 限流插件内部异常
 * @author Sailor-why
 */
public class InternalErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	public InternalErrorException(String message) {
		super(message);
	}

	public InternalErrorException(String message, Throwable e) {
		super(message, e);
	}
}
