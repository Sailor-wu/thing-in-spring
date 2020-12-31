package org.thing.in.spring.smallpcp.v1.controller;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thing.in.spring.smallpcp.v1.service.Metrics;

@Controller
@RequestMapping("/v1")
public class HelloController {
	private Metrics metrics = new Metrics();
	
	
	public HelloController() {
		System.out.println("构造执行===");
		metrics.startRepeatedReport(30, TimeUnit.SECONDS);
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
		return "my first hello word!";
	}
}
