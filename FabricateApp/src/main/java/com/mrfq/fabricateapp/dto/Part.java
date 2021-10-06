package com.mrfq.fabricateapp.dto;



import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class Part {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "partid")
	private Integer partId;
	
	@Column(name = "partdescription")
	private String partDescription;
	
	@Column(name = "partspecification")
	private String partSpecification;
	
	@Column(name = "stockinhand")
	private Integer stockInHand;
	
	public Part() {
		super();
	}
	
	public Part(Integer partId, String partDescription, String partSpecification, Integer stockInHand) {
		super();
		this.partId = partId;
		this.partDescription = partDescription;
		this.partSpecification=partSpecification;
		this.stockInHand=stockInHand;
	}

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public String getPartSpecification() {
		return partSpecification;
	}

	public void setPartSpecification(String partSpecification) {
		this.partSpecification = partSpecification;
	}

	public Integer getStockInHand() {
		return stockInHand;
	}

	public void setStockInHand(Integer stockInHand) {
		this.stockInHand = stockInHand;
	}
	
	
}
