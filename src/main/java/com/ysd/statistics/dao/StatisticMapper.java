package com.ysd.statistics.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ysd.statistics.entity.Statistics;

public interface StatisticMapper extends JpaRepository<Statistics, Integer> {
	
}
