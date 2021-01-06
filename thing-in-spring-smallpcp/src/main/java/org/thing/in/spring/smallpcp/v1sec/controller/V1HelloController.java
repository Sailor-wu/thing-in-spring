package org.thing.in.spring.smallpcp.v1sec.controller;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thing.in.spring.smallpcp.v1.service.Metrics;
import org.thing.in.spring.smallpcp.v1sec.entity.RequestInfo;
import org.thing.in.spring.smallpcp.v1sec.manager.ConsoleReporter;
import org.thing.in.spring.smallpcp.v1sec.manager.EmailReporter;
import org.thing.in.spring.smallpcp.v1sec.manager.MetricsCollector;
import org.thing.in.spring.smallpcp.v1sec.service.MetricsStorage;
import org.thing.in.spring.smallpcp.v1sec.service.impl.RedisMetricsStorage;

@Controller
@RequestMapping("/v1sec")
public class V1HelloController {
	private Metrics metrics = new Metrics();
	MetricsStorage storage;
	ConsoleReporter consoleReporter;
	MetricsCollector collector;
	
	public V1HelloController() {
		System.out.println("构造执行===");
		metrics.startRepeatedReport(30, TimeUnit.SECONDS);
		storage = new RedisMetricsStorage();
		consoleReporter = new ConsoleReporter(storage);
	    consoleReporter.startRepeatedReport(30, 30);
	    
	    collector = new MetricsCollector(storage);
	}


	@ResponseBody
	@RequestMapping("/user")
	public String index() {
		long startTimestamp = System.currentTimeMillis();
		metrics.recordTimestamp("index", startTimestamp);
		System.out.println("hello Word!");
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long responseTime = System.currentTimeMillis()-startTimestamp;
		metrics.recordResponseTime("index", responseTime);	
		collector.recordRequest(new RequestInfo("index",responseTime,System.currentTimeMillis()));
		return "my first hello word!";
	}
	
	@ResponseBody
	@RequestMapping("/hu")
	public String hu() {
		long startTimestamp = System.currentTimeMillis();
		metrics.recordTimestamp("hu", startTimestamp);
		System.out.println("hello Word!");
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long responseTime = System.currentTimeMillis()-startTimestamp;
		metrics.recordResponseTime("hu", responseTime);	
		collector.recordRequest(new RequestInfo("index",startTimestamp,10234));
		return "my first hello word!";
	}
	
	public static void main(String[] args) {
	    MetricsStorage storage = new RedisMetricsStorage();
	    ConsoleReporter consoleReporter = new ConsoleReporter(storage);
	    consoleReporter.startRepeatedReport(10, 60);
	
	    EmailReporter emailReporter = new EmailReporter(storage);
	    emailReporter.addToAddress("wangzheng@xzg.com");
	    emailReporter.startDailyReport();
	
	    MetricsCollector collector = new MetricsCollector(storage);
	    collector.recordRequest(new RequestInfo("register", 123, 10234));
	    collector.recordRequest(new RequestInfo("register", 223, 11234));
	    collector.recordRequest(new RequestInfo("register", 323, 12334));
	    collector.recordRequest(new RequestInfo("login", 23, 12434));
	    collector.recordRequest(new RequestInfo("login", 1223, 14234));
	
	    try {
	      Thread.sleep(100000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	  }
}
