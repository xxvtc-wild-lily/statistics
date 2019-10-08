package com.ysd.statistics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consumelogs")
public class ConsumeLogs {
	
	@Id
	@GeneratedValue
	private Integer con_id;
	private String con_cardNO;
	private Integer con_publicPlaceId;
	private String con_inTime;
	private String con_outTime;
	private Integer con_status;
	
}
