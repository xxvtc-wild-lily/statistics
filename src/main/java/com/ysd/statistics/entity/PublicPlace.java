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
	
}
