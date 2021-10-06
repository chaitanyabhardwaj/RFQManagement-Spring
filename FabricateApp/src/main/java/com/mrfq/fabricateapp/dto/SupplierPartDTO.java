package com.mrfq.fabricateapp.dto;

public class SupplierPartDTO {

    private SupplierDTO supplierObj;
    private PartDTO partObj;

    public SupplierPartDTO() {}

    public SupplierPartDTO(SupplierDTO supplierObj, PartDTO partObj) {
        this.supplierObj = supplierObj;
        this.partObj = partObj;
    }

    public SupplierDTO getSupplierObj() {
        return supplierObj;
    }

    public void setSupplierObj(SupplierDTO supplierObj) {
        this.supplierObj = supplierObj;
    }

    public PartDTO getPartObj() {
        return partObj;
    }

    public void setPartObj(PartDTO partObj) {
        this.partObj = partObj;
    }
}
