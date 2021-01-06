package org.thing.in.spring.smallpcp.v1sec.manager;

import org.springframework.util.StringUtils;
import org.thing.in.spring.smallpcp.v1sec.entity.RequestInfo;
import org.thing.in.spring.smallpcp.v1sec.service.MetricsStorage;

/**
 * desc 负责提供api 收集请求数据
 * @author Sailor-why
 */
public class MetricsCollector {

	private MetricsStorage metricsStorage;// 基于接口而非实现编程
	
	// 构造注入
	public MetricsCollector(MetricsStorage metricsStorage) {
		this.metricsStorage = metricsStorage;
	}
	
	// 收集数据
	public void recordRequest(RequestInfo info) {
		if(info == null || StringUtils.isEmpty(info.getApiName())){
			return;
		}
		metricsStorage.saveRequestInfo(info);
	}
}
