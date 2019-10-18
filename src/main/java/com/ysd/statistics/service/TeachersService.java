package com.ysd.statistics.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.statistics.entity.Teachers;

public interface TeachersService {
	
	Page<Teachers> findAll(Pageable pageable);
	
	Integer importTeachersExcel(MultipartFile multipartFile);

}
