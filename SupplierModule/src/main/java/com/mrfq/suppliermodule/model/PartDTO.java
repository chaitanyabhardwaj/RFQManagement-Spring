package com.mrfq.suppliermodule.model;

public class PartDTO {

    private long id;
    private long partId;
    private String name;
    private int quantity;
    private int timePeriod;

    public PartDTO() {};

    public PartDTO(Long partId, String name, int quantity, int timePeriod) {
        this.partId = partId;
        this.name = name;
        this.quantity = quantity;
        this.timePeriod = timePeriod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPartId() {
        return partId;
    }

    public void setPartId(long partId) {
        this.partId = partId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
