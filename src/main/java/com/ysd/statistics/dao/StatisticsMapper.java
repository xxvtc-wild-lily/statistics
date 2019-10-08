package com.ysd.statistics.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ysd.statistics.entity.ConsumeLogs;
import com.ysd.statistics.entity.DataChaXun;

public interface StatisticsMapper extends JpaRepository<ConsumeLogs,Integer>{
		@Transactional
		@Modifying
		@Query("select me.mem_degree as mingcheng,count(me.mem_degree) as counts from consumelogs co join students st on co.con_cardno=st.stu_cardno  join memberships me on st.stu_member_ship_id=me.mem_id where co.con_status=1 group by me.mem_degree")
		public List<DataChaXun> findeCount();
}
