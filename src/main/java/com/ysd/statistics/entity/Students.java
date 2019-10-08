package com.ysd.statistics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {
	
	@Id
	@GeneratedValue
	private Integer stu_id;
	private String stu_cardNO;
	private String stu_name;
	private Integer stu_sex;
	private Integer stu_memberShipId;
	private Integer stu_stuNO;
	private Integer stu_status;
	
}
