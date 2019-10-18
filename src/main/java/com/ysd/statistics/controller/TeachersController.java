package com.ysd.statistics.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.statistics.entity.Teachers;
import com.ysd.statistics.service.TeachersService;

@RestController
public class TeachersController {
	
	@Autowired
	private TeachersService teachersService;
	
	@PostMapping("/getAllTeachers")
	public Map<String,Object> getAllStudents(Integer page,Integer rows) {
		PageRequest pageRequest = new PageRequest(page - 1, rows);
		Page<Teachers> result = teachersService.findAll(pageRequest);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page", result.getNumber());
		map.put("total", result.getTotalElements());
		map.put("rows", result.getContent());
		
		return map;
	}
	
	@PostMapping("/importTeachersExcel")
	public Integer importTeachersExcel(@RequestParam(value = "file")MultipartFile multipartFile) throws IOException {
		return teachersService.importTeachersExcel(multipartFile);
	}
	
}
