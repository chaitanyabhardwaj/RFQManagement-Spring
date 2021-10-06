package com.mrfq.rfqmodule.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@NoArgsConstructor
@Entity
@Table(name="rfq_detail")
public class RfqDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rfqId;
    private Long partId;
    private Long supplierId;
    private String partName;
    private Long demandId;
    private Date expectedSupplyDate;
    private String specification;
    private int quantity;

    public RfqDetail(Long rfqId, Long partId, Long supplierId, String partName, Long demandId, Date expectedSupplyDate, String specification, int quantity) {
        this.rfqId = rfqId;
        this.partId = partId;
        this.supplierId = supplierId;
        this.partName = partName;
        this.demandId = demandId;
        this.expectedSupplyDate = expectedSupplyDate;
        this.specification = specification;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRfqId() {
        return rfqId;
    }

    public void setRfqId(Long rfqId) {
        this.rfqId = rfqId;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Long getDemandId() {
        return demandId;
    }

    public void setDemandId(Long demandId) {
        this.demandId = demandId;
    }

    public Date getExpectedSupplyDate() {
        return expectedSupplyDate;
    }

    public void setExpectedSupplyDate(Date expectedSupplyDate) {
        this.expectedSupplyDate = expectedSupplyDate;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RfqPart{" +
                "id=" + id +
                ", rfqId=" + rfqId +
                ", partId=" + partId +
                ", partName='" + partName + '\'' +
                ", demandId=" + demandId +
                ", expectedSupplyDate=" + expectedSupplyDate +
                ", specification='" + specification + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RfqDetail rfqPart = (RfqDetail) o;
        return rfqId.equals(rfqPart.rfqId) && partId.equals(rfqPart.partId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rfqId, partId);
    }
}
