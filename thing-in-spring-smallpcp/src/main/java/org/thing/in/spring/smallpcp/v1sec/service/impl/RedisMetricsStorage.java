package org.thing.in.spring.smallpcp.v1sec.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.thing.in.spring.smallpcp.v1sec.entity.RequestInfo;
import org.thing.in.spring.smallpcp.v1sec.service.MetricsStorage;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * desc redis 存储收集的数据   实现 存储数据接口 MetricsStorage 
 * @author Sailor-why
 */
public class RedisMetricsStorage implements MetricsStorage {

	static JedisPool pool;

	/**
	 * 静态构造redis
	 */
    public RedisMetricsStorage() {
    	if (pool == null) {
    		synchronized (RedisMetricsStorage.class) {
                pool = new JedisPool(new JedisPoolConfig(), "localhost");
                System.out.println("redis连接完成");
            }
        }

    }
	@Override
	public void saveRequestInfo(RequestInfo info) {
		Jedis jedis = null;
        try {
            jedis = pool.getResource();
            JSONObject json = new JSONObject();
            String jsonString = json.toJSONString(info);
			jedis.zadd(info.getApiName(), info.getTimestamp(), jsonString);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
	}

	@Override
	public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
		Jedis jedis = null;
        try {
            jedis = pool.getResource();
            JSONObject json = new JSONObject();
            Set<String> keyset = jedis.keys("*");
            Map<String, List<RequestInfo>> map = new LinkedHashMap<>();
            for (String key : keyset) {
//                Set<String> strs = jedis.zrangeByScore(key, startTimeInMillis, endTimeInMillis);
            	String strs = jedis.get(key);
                List<RequestInfo> requestInfos = new ArrayList<>();
//                for (String str : strs) {
                    RequestInfo requestInfo = json.parseObject(strs, RequestInfo.class);
                    requestInfos.add(requestInfo);
//                }
                map.put(key, requestInfos);
            }
            return map;
        } finally {
            // You have to close jedis object. If you don't close then
            // it doesn't release back to pool and you can't get a new
            // resource from pool.
            if (jedis != null) {
                jedis.close();
            }
        }
	}

}
