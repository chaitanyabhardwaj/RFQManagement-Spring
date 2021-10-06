package com.mrfq.rfqmodule.model;

import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
public class SupplierPart {

    private Long id;
    private Long partId;
    private String partName;
    private Long supplierId;
    private int quantity;
    private int timePeriod;

    public SupplierPart(Long partId, Long supplierId, String partName, int quantity, int timePeriod) {
        this.partId = partId;
        this.partName = partName;
        this.supplierId = supplierId;
        this.quantity = quantity;
        this.timePeriod = timePeriod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Override
    public String toString() {
        return "SupplierPart{" +
                "Id=" + id +
                ", partId=" + partId +
                ", supplierId=" + supplierId +
                ", partName='" + partName + '\'' +
                ", quantity=" + quantity +
                ", timePeriod=" + timePeriod +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierPart that = (SupplierPart) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
