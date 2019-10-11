package com.ysd.statistics.service;

import java.util.List;
import java.util.Map;

import com.ysd.statistics.entity.Statistics;

public interface ConsumeLogsService {
	/**
	 * 查询不同学历的学生在公共场合的人数
	 * @return
	 */
	public List<Map<String,Object>> findeCount();
	/**
	 * 查询上一个月各个场合的的记录
	 * @return
	 */
	public List<Map<String,Object>> findeOneMonthRecord();
	/**
	 * 上月各资源使用人次变化
	 * @return
	 */
	public List<Statistics> findOneMonthPublicPlaceRecord();
}
