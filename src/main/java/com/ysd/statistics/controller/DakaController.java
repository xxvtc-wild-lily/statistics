package com.ysd.statistics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.statistics.dao.DakaMapper;
import com.ysd.statistics.entity.PublicPlace;
import com.ysd.statistics.service.DakaService;

@RestController
public class DakaController {
	
	@Autowired
	private DakaMapper dakaMapper;
	@Autowired
	private DakaService dakaservcie;
	@PostMapping(value="/getAllPublicPlace")
	public List<PublicPlace> getAllPublicPlace() {
		return dakaMapper.findAll();
	}
	@PostMapping(value="/dakass")
	public Integer tadaka(Integer pub_id,String kh) {
		System.out.println("123123");
		
		Integer insertconsumelogs = dakaservcie.insertconsumelogs(kh, pub_id);
		return insertconsumelogs;
		
	}
	@PostMapping(value="/leave")
	public Integer leaves(Integer pub_id,String kh) {
		
		Integer updateconsumelogs = dakaservcie.updateconsumelogs(kh,pub_id);
		return updateconsumelogs;
		
	}
}
