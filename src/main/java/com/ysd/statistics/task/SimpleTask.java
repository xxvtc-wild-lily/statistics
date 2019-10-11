package com.ysd.statistics.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SimpleTask {
	
	
	@Resource
	private SimpleDateFormat dateFormat;
	
	/*
	 * @Scheduled(fixedRate = 1000 * 3) public void reportCurrentTime() {
	 * System.out.println("每隔3秒任务调度一次，现在时间：" + dateFormat.format(new Date())); }
	 */
	
	@Scheduled(cron = "*/5 * * * * ?")
	public void reportCurrentTimeCron() {
		System.out.println("每隔5秒任务调度一次 Scheduling Tasks Example By Cron: The time is now" + dateFormat.format(new Date()));
	}
	
}
