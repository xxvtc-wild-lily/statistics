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
	
}
