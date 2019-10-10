package com.ysd.statistics.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.statistics.entity.Students;
import com.ysd.statistics.service.StudentsService;

@RestController
public class StudentsController {
	
	@Autowired
	private StudentsService studentsService;
	
	@PostMapping("/getAllStudents")
	public Map<String,Object> getAllStudents(Integer page,Integer rows) {
		PageRequest pageRequest = new PageRequest(page - 1, rows);
		Page<Students> result = studentsService.findAll(pageRequest);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("page", result.getNumber());
		map.put("total", result.getTotalElements());
		map.put("rows", result.getContent());
		return map;
	}
	
	@PostMapping("/importStudentsExcel")
	public Integer importStudentsExcel(@RequestParam(value = "file")MultipartFile multipartFile,HttpServletResponse response) throws IOException {
		return studentsService.importStudentsExcel(multipartFile, response);
	}
	
}
