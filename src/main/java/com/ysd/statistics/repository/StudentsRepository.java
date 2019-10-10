package com.ysd.statistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ysd.statistics.entity.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
	
	@Query(value = "select stu_stuno from students where stu_stuno = ?1", nativeQuery = true)
	Integer findByStuNO(Integer stu_stuNO);
	
	@Query(value = "select stu_cardno from students where stu_cardno = ?1", nativeQuery = true)
	Integer findByStuCardNO(Integer stu_cardNO);
	
}
