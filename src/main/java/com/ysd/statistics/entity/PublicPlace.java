package com.ysd.statistics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publicplace")
public class PublicPlace {
	
	@Id
	@GeneratedValue
	private Integer pub_id;
	private String pub_name;
	private String pub_remark;
	public Integer getPub_id() {
		return pub_id;
	}
	public void setPub_id(Integer pub_id) {
		this.pub_id = pub_id;
	}
	public String getPub_name() {
		return pub_name;
	}
	public void setPub_name(String pub_name) {
		this.pub_name = pub_name;
	}
	public String getPub_remark() {
		return pub_remark;
	}
	public void setPub_remark(String pub_remark) {
		this.pub_remark = pub_remark;
	}
	
	
}
