package com.ysd.statistics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistics")
public class Statistics {
	
	@Id
	@GeneratedValue
	private Integer sta_id;
	private Integer sta_publicPlaceId;
	private Integer sta_peopleNums;
	private String sta_year;
	private String sta_month;
	private String sta_day;
	
}
