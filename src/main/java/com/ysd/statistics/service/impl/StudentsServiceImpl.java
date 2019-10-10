package com.ysd.statistics.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.statistics.entity.Students;
import com.ysd.statistics.enums.ImportResultEnum;
import com.ysd.statistics.repository.StudentsRepository;
import com.ysd.statistics.service.StudentsService;
import com.ysd.statistics.util.StudentsExcelUtil;

@Service
public class StudentsServiceImpl implements StudentsService {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Override
	public Page<Students> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return studentsRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Integer importStudentsExcel(MultipartFile multipartFile, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		StudentsExcelUtil studentsExcelUtil = new StudentsExcelUtil();
		// 获取excel数据并存入list
		List<Students> studentsList = studentsExcelUtil.getExcelInfo(multipartFile);
		// 声明异常的学生list
		List<Students> errorList = new ArrayList<Students>();
		// 声明异常的原因list
		List<String> errorReasonList = new ArrayList<String>();
		// 声明成功插入的学生信息数量
		Integer successInsertNum = 0;
		
		for (int i = 0;i < studentsList.size();i++) {
			// 声明学生类
			Students students = new Students();
			
			// 判断学号是否存在
			if (studentsRepository.findByStuNO(studentsList.get(i).getStu_stuNO()) == null) {
				// 判断卡号是否存在
				if (studentsRepository.findByStuCardNO(Integer.parseInt(studentsList.get(i).getStu_cardNO())) == null) {
					// 判断性别是否正确
					System.out.println(studentsList.get(i).getStu_sex());
					if (studentsList.get(i).getStu_sex() == 1 || studentsList.get(i).getStu_sex() == 0) {
						BeanUtils.copyProperties(studentsList.get(i), students);
						Students stu = studentsRepository.save(students);
						++successInsertNum;
					} else {
						errorReasonList.add(ImportResultEnum.STU_SEX_ERROR.getMessage());
						BeanUtils.copyProperties(studentsList.get(i), students);
						errorList.add(students);
					}
				} else {
					errorReasonList.add(ImportResultEnum.STU_CARDNO_ISEXISTS.getMessage());
					BeanUtils.copyProperties(studentsList.get(i), students);
					errorList.add(students);
				}
			} else {
				errorReasonList.add(ImportResultEnum.STUNO_ISEXISTS.getMessage());
				BeanUtils.copyProperties(studentsList.get(i), students);
				errorList.add(students);
			}
		}
		
		// 如果有错误信息则需要生成错误的excel
		if (errorList != null) {
			// 生成需要导出的错误excel
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 生成需要导出的错误sheet
			HSSFSheet hssfSheet = workbook.createSheet();
			// 生成绘图对象
	        HSSFPatriarch hssfPatriarch=hssfSheet.createDrawingPatriarch();
			
			// 设置行号
			Integer rowNum = 0;
			// 设置第一行
			Row row = hssfSheet.createRow(rowNum);
			// 设置行标题
			row.createCell(0).setCellValue("学生卡号");
			row.createCell(1).setCellValue("学生姓名");
			row.createCell(2).setCellValue("学生性别");
			row.createCell(3).setCellValue("学生专业信息编号");
			row.createCell(4).setCellValue("学生学号");
			row.createCell(4).setCellValue("错误信息");
			// 设置列宽
			hssfSheet.setColumnWidth(3, 16 * 256);
			hssfSheet.setColumnWidth(5, 15 * 256);
			// 设置错误数据
			for (int i = 0;i < errorList.size();i++) {
				// 创建行
				Row rows = hssfSheet.createRow(++rowNum);
				// 为改行每列赋值
				rows.createCell(0).setCellValue(errorList.get(i).getStu_cardNO());
				rows.createCell(1).setCellValue(errorList.get(i).getStu_name());
				rows.createCell(2).setCellValue(errorList.get(i).getStu_sex());
				rows.createCell(3).setCellValue(errorList.get(i).getStu_memberShipId());
				rows.createCell(4).setCellValue(errorList.get(i).getStu_stuNO());
				rows.createCell(5).setCellValue(errorReasonList.get(i).toString());
			}
			
			// 获取当前时间
			Calendar cal=Calendar.getInstance();
			int y=cal.get(Calendar.YEAR);
			int m=cal.get(Calendar.MONTH);
			int d=cal.get(Calendar.DATE);
			int h=cal.get(Calendar.HOUR_OF_DAY);
			int mi=cal.get(Calendar.MINUTE);
			int s=cal.get(Calendar.SECOND);
			
			
			// 设置向浏览器输出
			// OutputStream OutputStream = response.getOutputStream();
			// response.setCharacterEncoding("UTF-8");
			// 设置contentType为excel格式
			// response.setContentType("application/vnd.ms-excel;charset=utf-8");
			// response.setHeader("Content-Disposition", "Attachment;Filename=" + "有误学生信息_"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒.xls");
			// workbook.write(OutputStream);
			
			
			String path = "C:\\Users\\Sor3\\Desktop\\有误学生信息_"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒.xls";
			try {
				// 文件输出流
				FileOutputStream fileOutputStream = new FileOutputStream(path);
				try {
					workbook.write(fileOutputStream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// 判断是否全部插入成功
		if (studentsList.size() == successInsertNum) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
}
