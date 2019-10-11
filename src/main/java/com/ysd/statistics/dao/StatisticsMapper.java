package com.ysd.statistics.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.statistics.entity.PublicPlace;
import com.ysd.statistics.entity.Statistics;

public interface StatisticsMapper extends JpaRepository<Statistics,Integer>{
		/**
		 * 查询不同学历当前在公共场合的人数
		 * @return
		 */
		@Query(value="select  count(me.mem_degree) as `value` ,me.mem_degree as `name`  from consumelogs co join students st on co.con_cardno=st.stu_cardno  join memberships me on st.stu_member_ship_id=me.mem_id where co.con_status=1 group by me.mem_degree",nativeQuery = true)
		public List<Map<String, Object>> findCount();
		/**
		 * 查询上一个月各个场合的的记录
		 * @return
		 */
		@Query(value="select sum(st.sta_people_nums) as `value`,pu.pub_name as `name` from publicplace pu left join statistics st on pu.pub_id=st.sta_public_place_id WHERE st.sta_year=(select year (date_add(CURDATE(),interval -1 month))) and st.sta_month =(select month (date_add(CURDATE(),interval -1 month))) group by pu.pub_name",nativeQuery = true)
		public List<Map<String,Object>> findOneMonthRecord();
		/**
		 * 上月各资源使用人次变化
		 * @return
		 */
		@Query(value="select st.* from publicplace pu left join statistics st on pu.pub_id=st.sta_public_place_id WHERE st.sta_year=(select year (date_add(CURDATE(),interval -1 month))) and st.sta_month =(select month (date_add(CURDATE(),interval -1 month)))",nativeQuery = true)
		public List<Statistics> findOneMonthPublicPlaceRecord();
		/**
		 * 近30天不同专业图书馆使用的人次
		 * @return
		 */
		@Query(value="select  count(me.mem_department) as `value` ,me.mem_department as `name`  from consumelogs co join students st on co.con_cardno=st.stu_cardno  join memberships me on st.stu_member_ship_id=me.mem_id join publicplace pu on co.con_public_place_id = pu.pub_id where    DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(con_in_time)  and  pu.pub_name='图书馆' group by me.mem_department",nativeQuery = true)
		public List<Map<String,Object>> findRecordStudent();
		
		
}
