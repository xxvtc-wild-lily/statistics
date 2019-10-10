package com.ysd.statistics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ysd.statistics.repository.StudentsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsApplicationTests {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Test
	public void contextLoads() {
		System.out.println(studentsRepository.findAll().toString());
	}

}
