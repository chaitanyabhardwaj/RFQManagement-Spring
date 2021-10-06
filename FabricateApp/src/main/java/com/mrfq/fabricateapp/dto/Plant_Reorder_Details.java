package com.mrfq.fabricateapp.dto;


import org.springframework.stereotype.Component;
@Component
public class Plant_Reorder_Details {

	
	private Long reorderid;
	private Long partid;
	private Long plantid;
	private String partname;
	private Long reorderquantity;
	private Boolean reorderrequeststatus;
	private String reorderrequestdate;
	private String reorderexpecteddate;
	private Long demandid;
	
	public Long getReorderid() {
		return reorderid;
	}
	public void setReorderid(Long reorderid) {
		this.reorderid = reorderid;
	}
	public Long getPartid() {
		return partid;
	}
	public void setPartid(Long partid) {
		this.partid = partid;
	}
	public Long getPlantid() {
		return plantid;
	}
	public void setPlantid(Long plantid) {
		this.plantid = plantid;
	}
	public String getPartname() {
		return partname;
	}
	public void setPartname(String partname) {
		this.partname = partname;
	}
	public Long getReorderquantity() {
		return reorderquantity;
	}
	public void setReorderquantity(Long reorderquantity) {
		this.reorderquantity = reorderquantity;
	}
	public Boolean getReorderrequeststatus() {
		return reorderrequeststatus;
	}
	public void setReorderrequeststatus(Boolean reorderrequeststatus) {
		this.reorderrequeststatus = reorderrequeststatus;
	}
	public String getReorderrequestdate() {
		return reorderrequestdate;
	}
	public void setReorderrequestdate(String reorderrequestdate) {
		this.reorderrequestdate = reorderrequestdate;
	}
	public String getReorderexpecteddateDate() {
		return reorderexpecteddate;
	}
	public void setReorderexpecteddateDate(String reorderexpecteddate) {
		this.reorderexpecteddate = reorderexpecteddate;
	}
	public Plant_Reorder_Details(Long reorderid, Long partid, Long plantid, String partname, Long reorderquantity,
			Boolean reorderrequeststatus, String reorderrequestdate, String reorderexpecteddate,Long demandid) {
		super();
		this.reorderid = reorderid;
		this.partid = partid;
		this.plantid = plantid;
		this.partname = partname;
		this.reorderquantity = reorderquantity;
		this.reorderrequeststatus = reorderrequeststatus;
		this.reorderrequestdate = reorderrequestdate;
		this.reorderexpecteddate = reorderexpecteddate;
		this.demandid = demandid;
	}
	public Plant_Reorder_Details() {
		super();
	}
	
	public String getReorderexpecteddate() {
		return reorderexpecteddate;
	}
	public void setReorderexpecteddate(String reorderexpecteddate) {
		this.reorderexpecteddate = reorderexpecteddate;
	}
	public Long getDemandid() {
		return demandid;
	}
	public void setDemandid(Long demandid) {
		this.demandid = demandid;
	}


}
