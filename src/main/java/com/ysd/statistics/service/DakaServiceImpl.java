package com.ysd.statistics.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.statistics.dao.DakaMapper;

@Service
public class DakaServiceImpl implements DakaService {
	
	@Autowired
	private DakaMapper dakamapper;
	

	@Transactional
	public Integer insertconsumelogs(String kh, Integer pub_id) {
		Integer insertconsumelogs = dakamapper.insertconsumelogs(kh, pub_id);
		
		Object s=kh.subSequence(0, 1);
		
		if(s.equals("x")) {
			 dakamapper.updateStudent(kh, pub_id);
		}else {
			dakamapper.updateTeacher(kh, pub_id);
		}
		
		
		
		return insertconsumelogs;
	}

	@Transactional
	public Integer updateconsumelogs(String kh,Integer pub_id) {
		Integer updateconsumelogs = dakamapper.updateconsumelogs(kh);
		Object s=kh.subSequence(0, 1);

		if(s.equals("x")) {
			 dakamapper.updateStudent(kh, pub_id);
		}else {
			dakamapper.updateTeacher(kh, pub_id);
		}
		return updateconsumelogs;
	}

	

}
