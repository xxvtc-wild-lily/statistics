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
@Table(name = "statistics")
public class Statistics {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
	private Integer sta_id;
	/* private Integer sta_publicPlaceId; */
	private Integer sta_peopleNums;
	private String sta_year;
	private String sta_month;
	private String sta_day;
	@ManyToOne(targetEntity=PublicPlace.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="sta_publicPlaceId",referencedColumnName = "pub_id")
	private PublicPlace publicplace;
	
	public PublicPlace getPublicplace() {
		return publicplace;
	}
	public void setPublicplace(PublicPlace publicplace) {
		this.publicplace = publicplace;
	}
	public Integer getSta_id() {
		return sta_id;
	}
	public void setSta_id(Integer sta_id) {
		this.sta_id = sta_id;
	}

	/*
	 * public Integer getSta_publicPlaceId() { return sta_publicPlaceId; } public
	 * void setSta_publicPlaceId(Integer sta_publicPlaceId) { this.sta_publicPlaceId
	 * = sta_publicPlaceId; }
	 */
	public Integer getSta_peopleNums() {
		return sta_peopleNums;
	}
	public void setSta_peopleNums(Integer sta_peopleNums) {
		this.sta_peopleNums = sta_peopleNums;
	}
	public String getSta_year() {
		return sta_year;
	}
	public void setSta_year(String sta_year) {
		this.sta_year = sta_year;
	}
	public String getSta_month() {
		return sta_month;
	}
	public void setSta_month(String sta_month) {
		this.sta_month = sta_month;
	}
	public String getSta_day() {
		return sta_day;
	}
	public void setSta_day(String sta_day) {
		this.sta_day = sta_day;
	}
	
	
}
