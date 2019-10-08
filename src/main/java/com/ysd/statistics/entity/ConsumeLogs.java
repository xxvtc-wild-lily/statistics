package com.ysd.statistics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consumelogs")
public class ConsumeLogs {
	
	@Id
	@GeneratedValue
	private Integer con_id;
	private String con_cardNO;
	private Integer con_publicPlaceId;
	private String con_inTime;
	private String con_outTime;
	private Integer con_status;
	public Integer getCon_id() {
		return con_id;
	}
	public void setCon_id(Integer con_id) {
		this.con_id = con_id;
	}
	public String getCon_cardNO() {
		return con_cardNO;
	}
	public void setCon_cardNO(String con_cardNO) {
		this.con_cardNO = con_cardNO;
	}
	public Integer getCon_publicPlaceId() {
		return con_publicPlaceId;
	}
	public void setCon_publicPlaceId(Integer con_publicPlaceId) {
		this.con_publicPlaceId = con_publicPlaceId;
	}
	public String getCon_inTime() {
		return con_inTime;
	}
	public void setCon_inTime(String con_inTime) {
		this.con_inTime = con_inTime;
	}
	public String getCon_outTime() {
		return con_outTime;
	}
	public void setCon_outTime(String con_outTime) {
		this.con_outTime = con_outTime;
	}
	public Integer getCon_status() {
		return con_status;
	}
	public void setCon_status(Integer con_status) {
		this.con_status = con_status;
	}
	
	
}
