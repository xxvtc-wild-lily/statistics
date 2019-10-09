package com.ysd.statistics.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "computers")
public class Computers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
	private Integer com_id;
	private String com_name;
	private String com_ip;
	/* private Integer com_publicPlaceId; */
	private String com_remark;
	@ManyToOne(targetEntity=PublicPlace.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="com_publicPlaceId",referencedColumnName = "pub_id")
	private PublicPlace publicplace;
	
	public PublicPlace getPublicplace() {
		return publicplace;
	}
	public void setPublicplace(PublicPlace publicplace) {
		this.publicplace = publicplace;
	}
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

	/*
	 * public Integer getCom_publicPlaceId() { return com_publicPlaceId; } public
	 * void setCom_publicPlaceId(Integer com_publicPlaceId) { this.com_publicPlaceId
	 * = com_publicPlaceId; }
	 */
	public String getCom_remark() {
		return com_remark;
	}
	public void setCom_remark(String com_remark) {
		this.com_remark = com_remark;
	}
	
	
}
