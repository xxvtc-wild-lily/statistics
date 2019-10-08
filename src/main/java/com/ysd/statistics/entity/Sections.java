package com.ysd.statistics.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sections")
public class Sections {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
	private Integer sec_id;
	private String sec_name;
	private String sec_remark;
	public Integer getSec_id() {
		return sec_id;
	}
	public void setSec_id(Integer sec_id) {
		this.sec_id = sec_id;
	}
	public String getSec_name() {
		return sec_name;
	}
	public void setSec_name(String sec_name) {
		this.sec_name = sec_name;
	}
	public String getSec_remark() {
		return sec_remark;
	}
	public void setSec_remark(String sec_remark) {
		this.sec_remark = sec_remark;
	}
	
	
}
