package com.ysd.statistics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teachers {
	
	@Id
	@GeneratedValue
	private Integer tea_id;
	private String tea_cardNO;
	private String tea_name;
	private Integer tea_sex;
	private Integer tea_sectionId;
	private Integer tea_status;
	private String tea_remark;
	
}
