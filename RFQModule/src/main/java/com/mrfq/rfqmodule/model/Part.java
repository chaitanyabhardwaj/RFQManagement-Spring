package com.mrfq.rfqmodule.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Part {

	private int partId;
	private String PartDescription;
	private String PartSpecification;
	private int stockInHand;
	
	public Part(int partId, String partDescription, String partSpecification, int stockInHand) {
		this.partId = partId;
		PartDescription = partDescription;
		PartSpecification = partSpecification;
		this.stockInHand = stockInHand;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", PartDescription=" + PartDescription + ", PartSpecification="
				+ PartSpecification + ", stockInHand=" + stockInHand + "]";
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public String getPartDescription() {
		return PartDescription;
	}

	public void setPartDescription(String partDescription) {
		PartDescription = partDescription;
	}

	public String getPartSpecification() {
		return PartSpecification;
	}

	public void setPartSpecification(String partSpecification) {
		PartSpecification = partSpecification;
	}

	public int getStockInHand() {
		return stockInHand;
	}

	public void setStockInHand(int stockInHand) {
		this.stockInHand = stockInHand;
	}

}
