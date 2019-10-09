package com.ysd.statistics.service;

import java.util.List;
import java.util.Map;

import com.ysd.statistics.entity.ConsumeLogs;
import com.ysd.statistics.entity.DataChaXun;
import com.ysd.statistics.entity.Students;

public interface ConsumeLogsService {
	/**
	 * 查询不同学历的学生在公共场合的人数
	 * @return
	 */
	public List<Map<String,Object>> findeCount();

}
