package com.ysd.statistics.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.statistics.entity.ReadExcel;
import com.ysd.statistics.entity.Teachers;

/**
 *  * 文件导入数据库的工具类  * @author xy  *  
 */
public class TeachersExcelUtil {
	
		/**
		 * 先创建一个实体类
		 */
		ReadExcel readExcel = new ReadExcel();

		/**
		 * 读取Excel文件，获取信息集合
		 * 
		 * @param mFile
		 * @return
		 */
		public List<Teachers> getExcelInfo(MultipartFile mFile) {
			String fileName = mFile.getOriginalFilename();// 获取文件名
			List<Teachers> ilist = null;
			try {
				if (!validateExcel(fileName)) {// 验证文件名是否合格
					//不合格的话直接return
					return null;
				}
				boolean isExcel2003 = true;// 根据文件名判断是2003版本的还是2007版本的
				if (isExcel2007(fileName)) {
					isExcel2003 = false;
				}
				ilist = createExcel(mFile.getInputStream(), isExcel2003);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return ilist;
		}

		/**
		 * 判断是不是2003版本的excel
		 * 
		 * @param filePath
		 * @return
		 */
		public static boolean isExcel2003(String filePath) {
			return filePath.matches("^.+\\.(?i)(xls)$");
		}

		/**
		 * 判断是不是2007版本的excel
		 * 
		 * @param filePath
		 * @return
		 */
		public static boolean isExcel2007(String filePath) {
			return filePath.matches("^.+\\.(?i)(xlsx)$");
		}

		public boolean validateExcel(String filePath) {
			if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
				readExcel.setErrorMsg("文件名不是excel格式");
				return false;
			}
			return true;
		}

		/**
		 * 读取excel里面的客户信息
		 */
		public List<Teachers> readExcelValue(Workbook wb) {
			List<Teachers> ilist = new ArrayList<>();
			//先得到一个sheet
			Sheet sheet = wb.getSheetAt(0);
			//得到excel里面的行数
			int totalRows = sheet.getPhysicalNumberOfRows();
			readExcel.setTotalRows(totalRows);
			//得到excel里面的列，前提是有行

			//大于1是因为我从第二行就是数据了，这个大家看情况而定

			if (totalRows > 1 && sheet.getRow(0) != null) {
				int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
				readExcel.setTotalCells(totalCells);
			}

			for (int r = 1; r < totalRows; r++) {
				Row row = sheet.getRow(r);
				if (row == null) {
					continue;// 如果行为空的话直接中断
				}
				
				Teachers teachers =new Teachers();
				//循环xcel的列
				for (int c = 0; c < readExcel.getTotalCells(); c++) {
					Cell cell = row.getCell(c);
					if (cell != null) {
						
						if (c == 0) {
							// 老师卡号
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String tea_cardNO = String.valueOf(cell.getNumericCellValue());
								//截取如果length()-2为零了，就说明只有一位数，就直接截取0到1就行
								teachers.setTea_cardNO((tea_cardNO.substring(0, tea_cardNO.length() - 2 > 0 ? tea_cardNO.length() - 2 : 1)));
							} else {
								//如果不是纯数字可以直接获得名称
								teachers.setTea_cardNO(cell.getStringCellValue());
							}
						} else if (c == 1) {
							// 老师姓名
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String tea_name = String.valueOf(cell.getNumericCellValue());
								//截取如果length()-2为零了，就说明只有一位数，就直接截取0到1就行
								teachers.setTea_name(tea_name.substring(0, tea_name.length() - 2 > 0 ? tea_name.length() - 2 : 1));
							} else {
								//如果不是纯数字可以直接获得名称
								teachers.setTea_name(cell.getStringCellValue());
							}
						} else if (c == 2) {
							// 老师性别
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String tea_sex = String.valueOf(cell.getNumericCellValue());
								if (tea_sex.equals("男")) {
									teachers.setTea_sex(1);
								} else if (tea_sex.equals("女")) {
									teachers.setTea_sex(0);
								} else {
									teachers.setTea_sex(Integer.parseInt(tea_sex.substring(0, tea_sex.length() - 2 > 0 ? tea_sex.length() - 2 : 1)));
								}
								
							} else {
								//如果不是纯数字可以直接获得名称
								
								if (cell.getStringCellValue().equals("男")) {
									teachers.setTea_sex(1);
								} else if (cell.getStringCellValue().equals("女")) {
									teachers.setTea_sex(0);
								} else {
									teachers.setTea_sex(500);
								}
								
							}
						}else if (c == 3) {
							// 老师备注
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String tea_remark = String.valueOf(cell.getNumericCellValue());
								//截取如果length()-2为零了，就说明只有一位数，就直接截取0到1就行
								teachers.setTea_status(Integer.parseInt(tea_remark.substring(0, tea_remark.length() - 2 > 0 ? tea_remark.length() - 2 : 1)));
							} else {
								//如果不是纯数字可以直接获得名称
								teachers.setTea_status(Integer.parseInt(cell.getStringCellValue()));
							}
						}
						
					}
				}
				//最后将这些全部添加到ilist中
				ilist.add(teachers);
			}
			return ilist;
		}

		public List<Teachers> createExcel(InputStream is, boolean isExcel2003) {
			List<Teachers> ilist = null;
			try {
				Workbook wb = null;
				if (isExcel2003) {// 如果是2003版本的就new一个2003的wb出来
					wb = new HSSFWorkbook(is);
				} else {
					//否则就new 一个2007版的出来
					wb = new XSSFWorkbook(is);

				}
				//再让wb去解析readExcelValue(Workbook wb)方法
				ilist = readExcelValue(wb);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ilist;
		}
	}
