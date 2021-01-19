package org.thing.in.spring.v1.ratelimiter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.thing.in.spring.v1.ratelimiter.alg.RateLimitAlg;
import org.thing.in.spring.v1.ratelimiter.rule.ApiLimit;
import org.thing.in.spring.v1.ratelimiter.rule.RateLimitRule;
import org.thing.in.spring.v1.ratelimiter.rule.RuleConfig;
import org.thing.in.spring.v2.ratelimiter.exception.InternalErrorException;
import org.yaml.snakeyaml.Yaml;

/**
 * desc 用来串联整个限流流程
 * <p>
 * 先读取限流配置文件，映射为内存中的 java 对象 RuleCOnfig
 * <p>
 * 然后在将这个中建结构构建成一个快速查询的数据结构 RateLimitRule
 * <p>
 * 除此之外，还提供了最顶的限流接口 limit()
 * 
 * @author Sailor-why
 */
public class RateLimiter {

	// 为每个api在内存中存储限流计数器
	private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
	private RateLimitRule rule;

	public RateLimiter() {
		// 将限流规则配置文件ratelimiter-rule.yaml中的内容读取到RuleConfig中
		InputStream in = null;
		RuleConfig ruleConfig = null;
		Map<String, Object> map = null;
		try {
			in = this.getClass().getResourceAsStream("/org/thing/in/spring/v1/ratelimiter/ratelimiter-rule.yaml");
			if (in != null) {
				Yaml yaml = new Yaml();
//				ruleConfig = yaml.loadAs(in, RuleConfig.class);
				map = yaml.loadAs(in, Map.class);
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					System.out.printf("close file error:{%s}", e);
				}
			}
		}
		// 将限流规则构建成支持快速查找的数据结构RateLimitRule
		this.rule = new RateLimitRule(ruleConfig);
	}

	public boolean limit(String appId, String url) throws InternalErrorException {
		ApiLimit apiLimit = rule.getLimit(appId, url);
		if (apiLimit == null) {
			return true;
		}
		// 获取api对应在内存中的限流计数器（rateLimitCounter）
		String counterKey = appId + ":" + apiLimit.getApi();
		RateLimitAlg rateLimitCounter = counters.get(counterKey);
		if (rateLimitCounter == null) {
			RateLimitAlg newRateLimitCounter = new RateLimitAlg(apiLimit.getLimit());
			rateLimitCounter = counters.putIfAbsent(counterKey, newRateLimitCounter);
			if (rateLimitCounter == null) {
				rateLimitCounter = newRateLimitCounter;
			}
		} // 判断是否限流
		return rateLimitCounter.tryAcquire();
	}

}
