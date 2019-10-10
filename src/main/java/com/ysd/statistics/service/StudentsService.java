package com.ysd.statistics.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.statistics.entity.Students;

public interface StudentsService {
	
	Page<Students> findAll(Pageable pageable);
	
	Integer importStudentsExcel(MultipartFile multipartFile, HttpServletResponse response);
	
}
