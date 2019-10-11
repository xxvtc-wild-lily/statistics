package com.ysd.statistics.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.statistics.entity.Statistics;

public interface StatisticMapper extends JpaRepository<Statistics, Integer> {
	@Query(value="select sta.sta_peopleNums from statistics sta")
	public List<Map<String, Object>> findCount();
}
