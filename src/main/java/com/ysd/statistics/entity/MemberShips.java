package com.ysd.statistics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberships")
public class MemberShips {
	
	@Id
	@GeneratedValue
	private Integer mem_id;
	private String mem_department;
	private String mem_specialty;
	private String mem_degree;
	
}
