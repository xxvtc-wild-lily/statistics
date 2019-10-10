package com.ysd.statistics.entity;
/**
 * excel需要的相关参数
 * @author xy
 *
 */
public class ReadExcel {

	//总行数
	private int totalRows = 0;

	//总条数
	private int totalCells = 0;

	//错误信息的收集类
	private String errorMsg;


	public ReadExcel() {
	super();
	// TODO Auto-generated constructor stub
	}


	public int getTotalRows() {
	return totalRows;
	}


	public void setTotalRows(int totalRows) {
	this.totalRows = totalRows;
	}


	public int getTotalCells() {
	return totalCells;
	}


	public void setTotalCells(int totalCells) {
	this.totalCells = totalCells;
	}


	public String getErrorMsg() {
	return errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
	this.errorMsg = errorMsg;
	}

}
