package com.ysd.statistics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberships")
public class MemberShips {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
	private Integer mem_id;
	private String mem_department;
	private String mem_specialty;
	private String mem_degree;
	public Integer getMem_id() {
		return mem_id;
	}
	public void setMem_id(Integer mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_department() {
		return mem_department;
	}
	public void setMem_department(String mem_department) {
		this.mem_department = mem_department;
	}
	public String getMem_specialty() {
		return mem_specialty;
	}
	public void setMem_specialty(String mem_specialty) {
		this.mem_specialty = mem_specialty;
	}
	public String getMem_degree() {
		return mem_degree;
	}
	public void setMem_degree(String mem_degree) {
		this.mem_degree = mem_degree;
	}
	
	
}
