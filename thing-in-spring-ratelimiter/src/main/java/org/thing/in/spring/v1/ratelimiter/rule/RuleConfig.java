package org.thing.in.spring.v1.ratelimiter.rule;

import java.util.List;

/**
 * desc 规则
 * 
 * @author Sailor-why
 */
public class RuleConfig {

	private List<AppRuleConfig> configs;

	public List<AppRuleConfig> getConfigs() {
		return configs;
	}

	public void setConfigs(List<AppRuleConfig> configs) {
		this.configs = configs;
	}
}

class AppRuleConfig {
	private String appId;
	private List<ApiLimit> limits;

	public AppRuleConfig() {
	}

	public AppRuleConfig(String appId, List<ApiLimit> limits) {
		this.appId = appId;
		this.limits = limits;
	}

}
