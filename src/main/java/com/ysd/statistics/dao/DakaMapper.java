package com.ysd.statistics.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ysd.statistics.entity.PublicPlace;

public interface DakaMapper extends JpaRepository<PublicPlace,Integer>{
			@Query(value="update students set stu_status=?2 where stu_cardno=?1",nativeQuery = true)
			@Modifying
			@Transactional
	         public Integer updateStudent(String stu_cardno,Integer pub_id);
			@Query(value="update teachers set tea_status=?2 where tea_cardno=?1",nativeQuery = true)
			@Modifying
			@Transactional
	         public Integer updateTeacher(String tea_cardno,Integer pub_id);
			@Query(value="insert into consumelogs(con_cardno,con_in_time,con_public_place_id,con_status) value(?1,now(),?2,1)",nativeQuery = true)
			@Modifying
			@Transactional
	         public Integer insertconsumelogs(String kh,Integer pub_id);
			
			@Query(value="update consumelogs set con_out_time=now(),con_status=0 where con_cardno=?1 and con_status=1",nativeQuery = true)
			@Modifying
			@Transactional
			public Integer updateconsumelogs(String kh);
}
