package org.thing.in.spring.smallpcp.v1.service;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * desc 计算处理类
 * 
 * @author Sailor-why
 */
public class Metrics {

	// 创建散列表 记录对应的时间
	private Map<String, List<Double>> responseTimes = new HashMap<String, List<Double>>(100);
	private Map<String, List<Double>> timeStamps = new HashMap<String, List<Double>>(100);
	// 创建定时处理 线程池

	private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

	/**
	 * desc 记录接口请求的响应时间  根据 api name 记录时间 
	 */
	public void recordResponseTime(String apiName, double responseTime) {
		responseTimes.putIfAbsent(apiName, new ArrayList<Double>());
		responseTimes.get(apiName).add(responseTime);
	}

	/**
	 * desc 记录接口的请求访问时间  根据 api name 记录时间 
	 */
	public void recordTimestamp(String apiName, double timeStamp) {
		timeStamps.putIfAbsent(apiName, new ArrayList<Double>());
		timeStamps.get(apiName).add(timeStamp);
	}
	/**
	 * desc 以指定的频率 统计和输出结果
	 * @param period 频率
	 * @param unit 时间单位
	 * void
	 */
	public void startRepeatedReport(long period, TimeUnit unit) {
		// 指定时间运行指定次数
		executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				Map<String, Map<String, Double>> stats = new HashMap<>();
				// 接口响应最大值，最小值，平均值
				for (Entry<String, List<Double>> item : responseTimes.entrySet()) {
					String apiName = item.getKey();
					List<Double> value = item.getValue();
					stats.putIfAbsent(apiName, new HashMap<String, Double>());
					stats.get(apiName).put("max", max(value));
					stats.get(apiName).put("min", min(value));
					stats.get(apiName).put("avg", avg(value));
				}
				// 请求接口的访问次数
				for (Entry<String, List<Double>> item : timeStamps.entrySet()) {
					String apiName = item.getKey();
					List<Double> value = item.getValue();
					stats.putIfAbsent(apiName, new HashMap<String, Double>());
					stats.get(apiName).put("count", (double) value.size());
				}
				
				System.out.println(JSONObject.toJSON(stats));
			}
		}, 0, period, unit);
	}

	public double max(List<Double> dataset) {
		DoubleSummaryStatistics statistics = dataset.stream().mapToDouble(Number::doubleValue).summaryStatistics();
		return  statistics.getMax();
	}
	public double min(List<Double> dataset) {
		DoubleSummaryStatistics statistics = dataset.stream().mapToDouble(Number::doubleValue).summaryStatistics();
		return  statistics.getMin();
	}
	public double avg(List<Double> dataset) {
		DoubleSummaryStatistics statistics = dataset.stream().mapToDouble(Number::doubleValue).summaryStatistics();
		return statistics.getAverage();
	}
	
	
	public static void main(String[] args) {
		double e = 19.222;
		double a = 1.222;
		double b = 5.222;
		double c = 11.222;
		double d = 9.222;
		List<Double> dataset = new ArrayList<Double>();
		dataset.add(e);
		dataset.add(b);
		dataset.add(c);
		dataset.add(d);
		dataset.add(a);
		Metrics metrics = new Metrics();
		double max = metrics.max(dataset);
		System.out.printf("最大值：%s \n,平均值： %s \n最小值： %s \n ",max,metrics.avg(dataset),metrics.min(dataset));
	}

	
}
