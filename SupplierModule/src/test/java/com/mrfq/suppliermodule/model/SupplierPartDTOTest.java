package com.mrfq.suppliermodule.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class SupplierPartDTOTest {

    private SupplierPartDTO supplierPartDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getSupplierObj() {
        SupplierDTO supplier = new SupplierDTO("Chaitanya", "Dehradun", "chaitanya@gmail.com", "9876543210", 7);
        PartDTO part = new PartDTO(1L, "Gear", 10, 5);
        supplierPartDTO.setSupplierObj(supplier);
        supplierPartDTO.setPartObj(part);
        assertEquals(supplier.getName(), supplierPartDTO.getSupplierObj().getName());
    }

    @Test
    void setSupplierObj() {
        SupplierDTO supplier = new SupplierDTO("Chaitanya", "Dehradun", "chaitanya@gmail.com", "9876543210", 7);
        PartDTO part = new PartDTO(1L, "Gear", 10, 5);
        supplierPartDTO.setSupplierObj(supplier);
        supplierPartDTO.setPartObj(part);
        assertEquals(supplier.getName(), supplierPartDTO.getSupplierObj().getName());
    }

    @Test
    void getPartObj() {
        SupplierDTO supplier = new SupplierDTO("Chaitanya", "Dehradun", "chaitanya@gmail.com", "9876543210", 7);
        PartDTO part = new PartDTO(1L, "Gear", 10, 5);
        supplierPartDTO.setSupplierObj(supplier);
        supplierPartDTO.setPartObj(part);
        assertEquals(part.getName(), supplierPartDTO.getPartObj().getName());
    }

    @Test
    void setPartObj() {
        SupplierDTO supplier = new SupplierDTO("Chaitanya", "Dehradun", "chaitanya@gmail.com", "9876543210", 7);
        PartDTO part = new PartDTO(1L, "Gear", 10, 5);
        supplierPartDTO.setSupplierObj(supplier);
        supplierPartDTO.setPartObj(part);
        assertEquals(part.getName(), supplierPartDTO.getPartObj().getName());
    }
}