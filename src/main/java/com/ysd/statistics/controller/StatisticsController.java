package com.ysd.statistics.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.statistics.service.ConsumeLogsService;

@RestController
public class StatisticsController {
	

	@Autowired
	private ConsumeLogsService consumeLogsservice;
	@RequestMapping(value="index",method = RequestMethod.POST)
	public Object StatisticsConsumeLogs() {
		 List<Map<String, Object>> findeCount = consumeLogsservice.findeCount();
		
		return findeCount;
		
	}
	@RequestMapping(value="monthrecord",method = RequestMethod.POST)
	public Object selectOneMonthRecord() {
		List<Map<String, Object>> findeOneMonthRecord = consumeLogsservice.findeOneMonthRecord();
		return findeOneMonthRecord;
	}
	 
	public Object findAllStatisticsById() {
		
		return consumeLogsservice;
	}
}

