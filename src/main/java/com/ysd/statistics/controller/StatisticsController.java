package com.ysd.statistics.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.statistics.dao.StatisticsMapper;
import com.ysd.statistics.entity.ConsumeLogs;
import com.ysd.statistics.entity.DataChaXun;
import com.ysd.statistics.entity.Students;
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
}
