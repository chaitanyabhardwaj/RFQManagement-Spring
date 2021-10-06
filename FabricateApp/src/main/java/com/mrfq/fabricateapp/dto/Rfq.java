package com.mrfq.fabricateapp.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
public class Rfq {


    private Long id;

    private Long partId;

    public Rfq(Long partId) {
        this.partId = partId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rfq rfq = (Rfq) o;
        return id.equals(rfq.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
