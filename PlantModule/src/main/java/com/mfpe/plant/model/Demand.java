package com.mfpe.plant.model;

import lombok.NoArgsConstructor;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity(name="Demand")
public class Demand {
	@Id
	private Integer demandId;
	private Integer partId;
	private Integer demandCount;
	private Date demandRaisedDate;

	public Demand(Integer demandId, Integer partId, Integer demandCount, Date demandRaisedDate) {
		super();
		this.demandId = demandId;
		this.partId = partId;
		this.demandCount = demandCount;
		this.demandRaisedDate = demandRaisedDate;
	}
	@Override
	public String toString() {
		return "Demand [demandId=" + demandId + ", partId=" + partId + ", demandCount=" + demandCount
				+ ", demandRaisedDate=" + demandRaisedDate + "]";
	}
	public Integer getDemandId() {
		return demandId;
	}
	public void setDemandId(Integer demandId) {
		this.demandId = demandId;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public Integer getDemandCount() {
		return demandCount;
	}
	public void setDemandCount(Integer demandCount) {
		this.demandCount = demandCount;
	}
	public Date getDemandRaisedDate() {
		return demandRaisedDate;
	}
	public void setDemandRaisedDate(Date demandRaisedDate) {
		this.demandRaisedDate = demandRaisedDate;
	}
}
