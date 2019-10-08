package com.ysd.statistics.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sections")
public class Sections {
	
	@Id
	@GeneratedValue
	private Integer sec_id;
	private String sec_name;
	private String sec_remark;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "")
	private List<Teachers> teachers;
	
}
