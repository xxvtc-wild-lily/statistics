package com.ysd.statistics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "computers")
public class Computers {
	
	@Id
	@GeneratedValue
	private Integer com_id;
	private String com_name;
	private String com_ip;
	private Integer com_publicPlaceId;
	private String com_remark;
	public Integer getCom_id() {
		return com_id;
	}
	public void setCom_id(Integer com_id) {
		this.com_id = com_id;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getCom_ip() {
		return com_ip;
	}
	public void setCom_ip(String com_ip) {
		this.com_ip = com_ip;
	}
	public Integer getCom_publicPlaceId() {
		return com_publicPlaceId;
	}
	public void setCom_publicPlaceId(Integer com_publicPlaceId) {
		this.com_publicPlaceId = com_publicPlaceId;
	}
	public String getCom_remark() {
		return com_remark;
	}
	public void setCom_remark(String com_remark) {
		this.com_remark = com_remark;
	}
	
	
}
