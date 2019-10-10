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
@Table(name = "students")
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
	private Integer stu_id;
	private String stu_cardNO;
	private String stu_name;
	private Integer stu_sex;
	private Integer stu_stuNO;
	private Integer stu_status;
	@ManyToOne(targetEntity=MemberShips.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="stu_memberShipId",referencedColumnName = "mem_id")
	private MemberShips memberships;
	public MemberShips getMemberships() {
		return memberships;
	}
	public void setMemberships(MemberShips memberships) {
		this.memberships = memberships;
	}
	public Integer getStu_id() {
		return stu_id;
	}
	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_cardNO() {
		return stu_cardNO;
	}
	public void setStu_cardNO(String stu_cardNO) {
		this.stu_cardNO = stu_cardNO;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public Integer getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(Integer stu_sex) {
		this.stu_sex = stu_sex;
	}
	public Integer getStu_stuNO() {
		return stu_stuNO;
	}
	public void setStu_stuNO(Integer stu_stuNO) {
		this.stu_stuNO = stu_stuNO;
	}
	public Integer getStu_status() {
		return stu_status;
	}
	public void setStu_status(Integer stu_status) {
		this.stu_status = stu_status;
	}
<<<<<<< HEAD
	
=======
	@Override
	public String toString() {
		return "Students [stu_id=" + stu_id + ", stu_cardNO=" + stu_cardNO + ", stu_name=" + stu_name + ", stu_sex="
				+ stu_sex + ", stu_stuNO=" + stu_stuNO + ", stu_status="
				+ stu_status + "]";
	}
>>>>>>> parent of 94c33dd... Revert "修改配置"
	
}
