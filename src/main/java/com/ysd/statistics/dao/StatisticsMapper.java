package com.ysd.statistics.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysd.statistics.entity.Statistics;

public interface StatisticsMapper extends JpaRepository<Statistics, Integer> {
	public List<Statistics> findAll();
}
