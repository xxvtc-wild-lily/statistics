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
@Table(name = "teachers")
public class Teachers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
	private Integer tea_id;
	private String tea_cardNO;
	private String tea_name;
	private Integer tea_sex;
	/* private Integer tea_sectionId; */
	private Integer tea_status;
	private String tea_remark;
	@ManyToOne(targetEntity=Sections.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="tea_sectionId",referencedColumnName = "sec_id")
	private Sections sections;
	
	public Sections getSections() {
		return sections;
	}
	public void setSections(Sections sections) {
		this.sections = sections;
	}
	public Integer getTea_id() {
		return tea_id;
	}
	public void setTea_id(Integer tea_id) {
		this.tea_id = tea_id;
	}
	public String getTea_cardNO() {
		return tea_cardNO;
	}
	public void setTea_cardNO(String tea_cardNO) {
		this.tea_cardNO = tea_cardNO;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public Integer getTea_sex() {
		return tea_sex;
	}
	public void setTea_sex(Integer tea_sex) {
		this.tea_sex = tea_sex;
	}

	/*
	 * public Integer getTea_sectionId() { return tea_sectionId; } public void
	 * setTea_sectionId(Integer tea_sectionId) { this.tea_sectionId = tea_sectionId;
	 * }
	 */
	public Integer getTea_status() {
		return tea_status;
	}
	public void setTea_status(Integer tea_status) {
		this.tea_status = tea_status;
	}
	public String getTea_remark() {
		return tea_remark;
	}
	public void setTea_remark(String tea_remark) {
		this.tea_remark = tea_remark;
	}
	
	
}
