package com.mrfq.fabricateapp.dto;

import org.springframework.stereotype.Component;

@Component
public class Reorder_Rules {

	private Long partid;
	private Long minquantity;
	private Long maxquantity;
	private Long reorderfrequency;

	public Long getMinquantity() {
		return minquantity;
	}

	public void setMinquantity(Long minquantity) {
		this.minquantity = minquantity;
	}

	public Long getMaxquantity() {
		return maxquantity;
	}

	public void setMaxquantity(Long maxquantity) {
		this.maxquantity = maxquantity;
	}

	public Long getReorderfrequency() {
		return reorderfrequency;
	}

	public void setReorderfrequency(Long reorderfrequency) {
		this.reorderfrequency = reorderfrequency;
	}

	public Long getPartid() {
		return partid;
	}

	public void setPartid(Long partid) {
		this.partid = partid;
	}

	public Reorder_Rules(Long minquantity, Long maxquantity, Long reorderfrequency, Long partid) {
		super();
		this.minquantity = minquantity;
		this.maxquantity = maxquantity;
		this.reorderfrequency = reorderfrequency;
		this.partid = partid;
	}

	public Reorder_Rules() {
		super();
	}

	@Override
	public String toString() {
		return "Reorder_Rules [partid=" + partid + ", minquantity=" + minquantity + ", maxquantity=" + maxquantity
				+ ", reorderfrequency=" + reorderfrequency + "]";
	}

}
