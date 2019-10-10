package com.ysd.statistics.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.statistics.dao.StatisticsMapper;
import com.ysd.statistics.entity.ConsumeLogs;
import com.ysd.statistics.entity.DataChaXun;
import com.ysd.statistics.entity.Students;
@Service
public class ConsumeLogsServiceImpl implements ConsumeLogsService {
	@Autowired
	private StatisticsMapper statisticsmapper;
	@Override
	public List<Map<String, Object>> findeCount() {
		List<Map<String, Object>> findCount = statisticsmapper.findCount();
		return findCount;
	}

}
