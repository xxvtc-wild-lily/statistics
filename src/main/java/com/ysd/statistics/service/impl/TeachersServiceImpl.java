package com.ysd.statistics.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.statistics.entity.Teachers;
import com.ysd.statistics.enums.ImportResultEnum;
import com.ysd.statistics.repository.TeachersRepository;
import com.ysd.statistics.service.TeachersService;
import com.ysd.statistics.util.TeachersExcelUtil;

@Service
public class TeachersServiceImpl implements TeachersService {

	@Autowired
	private TeachersRepository teachersRepository;

	@Override
	public Page<Teachers> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return teachersRepository.findAll(pageable);
	}

	@Override
	public Integer importTeachersExcel(MultipartFile multipartFile) {
		// TODO Auto-generated method stub

		// 声明工具类
		TeachersExcelUtil teachersExcelUtil = new TeachersExcelUtil();
		// 获取excel数据并存入list
		List<Teachers> teachersList = teachersExcelUtil.getExcelInfo(multipartFile);
		// 声明异常的老师list
		List<Teachers> errorList = new ArrayList<Teachers>();
		// 声明异常的原因list
		List<String> errorReasonList = new ArrayList<String>();
		// 声明成功插入的老师信息数量
		Integer successInsertNum = 0;

		for (int i = 0; i < teachersList.size(); i++) {
			System.out.println(teachersList.get(i));
			// 声明老师类
			Teachers teachers = new Teachers();
			
			System.out.println(teachersList.get(i).getTea_cardNO());
			
			// 判断卡号是否存在
			if (teachersRepository.findByTeaCardNO(String.valueOf(teachersList.get(i).getTea_cardNO())) == null) {
				// 判断性别是否正确
				
				if (teachersList.get(i).getTea_sex() == 1 || teachersList.get(i).getTea_sex() == 0) {
					BeanUtils.copyProperties(teachersList.get(i), teachers);
					Teachers tea = teachersRepository.save(teachers);
					++successInsertNum;
				} else {
					errorReasonList.add(ImportResultEnum.TEA_SEX_ERROR.getMessage());
					BeanUtils.copyProperties(teachersList.get(i), teachers);
					errorList.add(teachers);
				}
			} else {
				errorReasonList.add(ImportResultEnum.TEA_CARDNO_ISEXISTS.getMessage());
				BeanUtils.copyProperties(teachersList.get(i), teachers);
				errorList.add(teachers);
			}
		}

		// 如果有错误信息则需要生成错误的excel
		if (errorList != null) {
			// 生成需要导出的错误excel
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 生成需要导出的错误sheet
			HSSFSheet hssfSheet = workbook.createSheet();
			// 生成绘图对象
			HSSFPatriarch hssfPatriarch = hssfSheet.createDrawingPatriarch();

			// 设置行号
			Integer rowNum = 0;
			// 设置第一行
			Row row = hssfSheet.createRow(rowNum);
			// 设置行标题
			row.createCell(0).setCellValue("教师卡号");
			row.createCell(1).setCellValue("教师姓名");
			row.createCell(2).setCellValue("教师性别");
			row.createCell(3).setCellValue("教师备注");
			row.createCell(4).setCellValue("错误信息");
			// 设置列宽
			hssfSheet.setColumnWidth(4, 15 * 256);
			// 设置错误数据
			for (int i = 0; i < errorList.size(); i++) {
				// 创建行
				Row rows = hssfSheet.createRow(++rowNum);
				// 为改行每列赋值
				rows.createCell(0).setCellValue(errorList.get(i).getTea_cardNO());
				rows.createCell(1).setCellValue(errorList.get(i).getTea_name());
				rows.createCell(2).setCellValue(errorList.get(i).getTea_sex());
				rows.createCell(3).setCellValue(errorList.get(i).getTea_remark());
				rows.createCell(4).setCellValue(errorReasonList.get(i).toString());
			}

			// 获取当前时间
			Calendar cal = Calendar.getInstance();
			int y = cal.get(Calendar.YEAR);
			int m = cal.get(Calendar.MONTH);
			int d = cal.get(Calendar.DATE);
			int h = cal.get(Calendar.HOUR_OF_DAY);
			int mi = cal.get(Calendar.MINUTE);
			int s = cal.get(Calendar.SECOND);

			// 设置向浏览器输出
			// OutputStream OutputStream = response.getOutputStream();
			// response.setCharacterEncoding("UTF-8");
			// 设置contentType为excel格式
			// response.setContentType("application/vnd.ms-excel;charset=utf-8");
			// response.setHeader("Content-Disposition", "Attachment;Filename=" +
			// "有误学生信息_"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒.xls");
			// workbook.write(OutputStream);

			String path = "C:\\Users\\Sor3\\Desktop\\有误教师信息_" + y + "年" + m + "月" + d + "日" + h + "时" + mi + "分" + s
					+ "秒.xls";
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
		if (teachersList.size() == successInsertNum) {
			return 1;
		} else {
			return 0;
		}
		
	}

}
