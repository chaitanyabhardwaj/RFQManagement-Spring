package com.mfpe.plant.model;

import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity(name="PlantReorderDetails")
public class PlantReorderDetails {
	
	@Id
	private Integer partId;
	private String reorderStatus;
	private Date reorderDate;
	@Override
	public String toString() {
		return "PlantReorderDetails [partId=" + partId + ", reorderStatus=" + reorderStatus + ", reorderDate="
				+ reorderDate + "]";
	}
	
	public PlantReorderDetails(Integer partId, String reorderStatus, Date reorderDate) {
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
