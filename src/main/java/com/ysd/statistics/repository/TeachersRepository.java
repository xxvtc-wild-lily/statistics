package com.ysd.statistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ysd.statistics.entity.Teachers;

public interface TeachersRepository extends JpaRepository<Teachers, Integer> {
	
	@Query(value = "select tea_cardno from teachers where tea_cardno = ?1", nativeQuery = true)
	String findByTeaCardNO(String tea_cardNO);
	
}
