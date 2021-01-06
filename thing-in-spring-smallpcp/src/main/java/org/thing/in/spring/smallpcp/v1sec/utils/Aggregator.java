package org.thing.in.spring.smallpcp.v1sec.utils;
/**
 * desc 统计工具类  负责根据袁术数据进行统计和求各种数据值
 * @author Sailor-why
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.thing.in.spring.smallpcp.v1sec.entity.RequestInfo;
import org.thing.in.spring.smallpcp.v1sec.entity.RequestStat;

public class Aggregator {

	public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {
		double maxRespTime = Double.MIN_VALUE; // 最大值
		double minRespTime = Double.MAX_VALUE; // 最小值
		double avgRespTime = -1;	//平均值
		double p999RespTime = -1;	// 99.9百分位值
		double p99RespTime = -1;	// 99百分位值
		double sumRespTime = 0; 	// 总响应时间
		long count = 0;				// 接口请求次数
		for (RequestInfo requestInfo : requestInfos) {
			++count;
			double respTime = requestInfo.getResponseTime();
			if (maxRespTime < respTime) {
				maxRespTime = respTime;
			}
			if (minRespTime > respTime) {
				minRespTime = respTime;
			}
			sumRespTime += respTime;
		}
		if (count != 0) {
			avgRespTime = sumRespTime / count;
		}
		long tps = (long) (count / durationInMillis * 1000); 
		Collections.sort(requestInfos, new Comparator<RequestInfo>() {
			@Override
			public int compare(RequestInfo o1, RequestInfo o2) {
				double diff = o1.getResponseTime() - o2.getResponseTime();
				if (diff < 0.0) {
					return -1;
				} else if (diff > 0.0) {
					return 1;
				} else {
					return 0;
				}
			}
		}); 
		int idx999 = (int) (count * 0.999);
		int idx99 = (int) (count * 0.99);
		if (count != 0) {
			p999RespTime = requestInfos.get(idx999).getResponseTime();
			p99RespTime = requestInfos.get(idx99).getResponseTime();
		}
		RequestStat requestStat = new RequestStat();
		requestStat.setMaxResponseTime(maxRespTime);
		requestStat.setMinResponseTime(minRespTime);
		requestStat.setAvgResponseTime(avgRespTime);
		requestStat.setP999ResponseTime(p999RespTime);
		requestStat.setP99ResponseTime(p99RespTime);
		requestStat.setCount(count);
		requestStat.setTps(tps);
		return requestStat;
	}
}
