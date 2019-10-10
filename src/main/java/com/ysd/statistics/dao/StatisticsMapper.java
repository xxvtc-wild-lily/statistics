package com.ysd.statistics.dao;

import java.util.List;
<<<<<<< HEAD

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysd.statistics.entity.Statistics;

public interface StatisticsMapper extends JpaRepository<Statistics, Integer> {
	public List<Statistics> findAll();
=======
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ysd.statistics.entity.Students;

public interface StatisticsMapper extends JpaRepository<Students,Integer>{
		@Query(value="select  count(me.mem_degree) as `value` ,me.mem_degree as `name`  from consumelogs co join students st on co.con_cardno=st.stu_cardno  join memberships me on st.stu_member_ship_id=me.mem_id where co.con_status=1 group by me.mem_degree",nativeQuery = true)
		public List<Map<String, Object>> findCount();
		
	/*
	 * select pu.*,st.* from publicplace pu left join statistics st on
	 * pu.pub_id=st.sta_public_place_id WHERE st.sta_year=(select year
	 * (date_add(CURDATE(),interval -1 month))) and st.sta_month =(select month
	 * (date_add(CURDATE(),interval -1 month)))
	 */
>>>>>>> master
}
