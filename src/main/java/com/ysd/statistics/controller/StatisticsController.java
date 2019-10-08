package com.ysd.statistics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.statistics.dao.StatisticsMapper;
import com.ysd.statistics.entity.ConsumeLogs;
import com.ysd.statistics.entity.DataChaXun;

@RestController
public class StatisticsController {
	@Autowired
	private StatisticsMapper statisticsmapper;
	@RequestMapping(value="index",method = RequestMethod.POST)
	public Object StatisticsConsumeLogs() {
		List<DataChaXun> findeCount = statisticsmapper.findeCount();
		return findeCount;
		
	}
}
