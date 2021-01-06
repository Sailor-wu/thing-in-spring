package org.thing.in.spring.smallpcp.v1sec.service;

import java.util.List;
import java.util.Map;

import org.thing.in.spring.smallpcp.v1sec.entity.RequestInfo;

/**
 * desc 负责数据的存储 只提供接口，具体的实现由具体类来实现  比如 Redis hbase ....
 * @author Sailor-why
 */
public interface MetricsStorage {

	void saveRequestInfo(RequestInfo info);

	Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
	
}
