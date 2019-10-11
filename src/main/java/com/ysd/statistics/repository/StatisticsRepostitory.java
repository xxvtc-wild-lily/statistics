package com.ysd.statistics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.statistics.entity.Statistics;

public interface StatisticsRepostitory extends JpaRepository<Statistics, Integer> {
	
	@Query(value = "select pp.pub_id as sta_public_palce_id,count(cl.con_cardno) as sta_people_nums from publicplace pp inner join consumelogs cl on pp.pub_id = cl.con_public_place_id where cl.con_in_time between :startTime and :endTime group by pp.pub_id", nativeQuery = true)
	List<Map<String, Object>> selectTodayUserInfo(@Param("startTime") String startTime,@Param("endTime") String endTime);
	
	@Query(value = "insert into statistics(sta_public_place_id,sta_people_nums,sta_year,sta_month,sta_day) values(?1,?2,?3,?4,?5)", nativeQuery = true)
	@Modifying
	@Transactional
	Integer insertStatistics(Integer publicPlaceId,Integer peopleNum,String year,String month,String day);
	
}
