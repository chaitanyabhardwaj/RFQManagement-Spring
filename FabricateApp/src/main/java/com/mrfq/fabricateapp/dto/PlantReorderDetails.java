package com.mrfq.fabricateapp.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plantReorderDetails")
public class PlantReorderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name= "partid")
	private Integer partId;
	
	@Column(name= "reorderstatus")
	private String reorderStatus;
	
	@Column(name= "reorderdate")
	private Date reorderDate;
	
	
	
	public PlantReorderDetails() {
		super();
	}

	public PlantReorderDetails(Integer reorderId, Integer partId, String reorderStatus, Date reorderDate) {
		super();
		this.partId = partId;
		this.reorderStatus = reorderStatus;
		this.reorderDate = reorderDate;
	}


	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getReorderStatus() {
		return reorderStatus;
	}

	public void setReorderStatus(String reorderStatus) {
		this.reorderStatus = reorderStatus;
	}

	public Date getReorderDate() {
		return reorderDate;
	}

	public void setReorderDate(Date reorderDate) {
		this.reorderDate = reorderDate;
	}
	
	

}
