package com.ysd.statistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.statistics.dao.StatisticsMapper;

@RestController
public class StatisticsController {
	@Autowired
	private StatisticsMapper statisticsMapper;
	
	
}

