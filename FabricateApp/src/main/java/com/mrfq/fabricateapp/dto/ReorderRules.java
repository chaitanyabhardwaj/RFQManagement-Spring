package com.mrfq.fabricateapp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ReorderRules")
public class ReorderRules {
	
	@Id
	private Integer partId;
	private Integer demandId;
	private Integer minQuantity;
	private Integer maxQuantity;
	private Integer reorderFrequency;

	public ReorderRules() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReorderRules(Integer partId, Integer demandId, Integer minQuantity, Integer maxQuantity,
			Integer reorderFrequency) {
		super();
		this.partId = partId;
		this.demandId = demandId;
		this.minQuantity = minQuantity;
		this.maxQuantity = maxQuantity;
		this.reorderFrequency = reorderFrequency;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public Integer getDemandId() {
		return demandId;
	}
	public void setDemandId(Integer demandId) {
		this.demandId = demandId;
	}
	public Integer getMinQuantity() {
		return minQuantity;
	}
	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}
	public Integer getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(Integer maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public Integer getReorderFrequency() {
		return reorderFrequency;
	}
	public void setReorderFrequency(Integer reorderFrequency) {
		this.reorderFrequency = reorderFrequency;
	}
	@Override
	public String toString() {
		return "ReorderRules [partId=" + partId + ", demandId=" + demandId + ", minQuantity=" + minQuantity
				+ ", maxQuantity=" + maxQuantity + ", reorderFrequency=" + reorderFrequency + "]";
	}
}
