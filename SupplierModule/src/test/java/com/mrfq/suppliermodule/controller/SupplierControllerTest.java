package com.mrfq.suppliermodule.controller;

import com.mrfq.suppliermodule.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SupplierControllerTest {

    @Mock
    private SupplierController supplierController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addSupplier() {
        SupplierDTO supplier = new SupplierDTO("Chaitanya", "Dehradun", "chaitanya@gmail.com", "9876543210", 7);
        //supplier.setId(1L);
        PartDTO part = new PartDTO(1L, "Gear", 10, 5);
        part.setId(1L);
        SupplierPartDTO supplierPartDTO = new SupplierPartDTO(supplier, part);
        ResponseEntity<SupplierPart> supplierPart = supplierController.addSupplier(supplierPartDTO);
        assertEquals(1L, Objects.requireNonNull(supplierPart.getBody()).getSupplierId());
    }

    @Test
    void getSupplier() {
        //adding supplier
        SupplierDTO supplier = new SupplierDTO("Chaitanya", "Dehradun", "chaitanya@gmail.com", "9876543210", 7);
        //supplier.setId(1L);
        PartDTO part = new PartDTO(1L, "Gear", 10, 5);
        part.setId(1L);
        SupplierPartDTO supplierPartDTO = new SupplierPartDTO(supplier, part);
        ResponseEntity<SupplierPart> supplierPart = supplierController.addSupplier(supplierPartDTO);

        //getting supplier
        ResponseEntity<Supplier> result = supplierController.getSupplier(supplierPart.getBody().getSupplierId());
        assertEquals("Chaitanya", Objects.requireNonNull(result.getBody()).getName());
    }

    @Test
    void editSupplier() {
        //adding supplier
        SupplierDTO supplier = new SupplierDTO("Chaitanya", "Dehradun", "chaitanya@gmail.com", "9876543210", 7);
        //supplier.setId(1L);
        PartDTO part = new PartDTO(1L, "Gear", 10, 5);
        part.setId(1L);
        SupplierPartDTO supplierPartDTO = new SupplierPartDTO(supplier, part);
        ResponseEntity<SupplierPart> supplierPart = supplierController.addSupplier(supplierPartDTO);

        //editing supplier
        supplier.setId(supplierPart.getBody().getSupplierId());
        supplier.setEmail("somesh@gmail.com");
        ResponseEntity<Supplier> result = supplierController.editSupplier(supplier);
        assertEquals("somesh@gmail.com", Objects.requireNonNull(result.getBody()).getEmail());
    }

    @Test
    void updateFeedback() {
        //adding supplier
        SupplierDTO supplier = new SupplierDTO("Chaitanya", "Dehradun", "chaitanya@gmail.com", "9876543210", 7);
        //supplier.setId(1L);
        PartDTO part = new PartDTO(1L, "Gear", 10, 5);
        part.setId(1L);
        SupplierPartDTO supplierPartDTO = new SupplierPartDTO(supplier, part);
        ResponseEntity<SupplierPart> supplierPart = supplierController.addSupplier(supplierPartDTO);

        //updating supplier feedback
        supplier.setId(supplierPart.getBody().getSupplierId());
        supplier.setFeedback(10);
        ResponseEntity<String> result = supplierController.updateFeedback(supplier);
        assertEquals("Supplier ID: " + supplier.getId() + "\nUpdated feedback: " +
                supplier.getFeedback(), result.getBody());
    }

    @Test
    void getSupplierOfPart() {
        //adding supplier
        SupplierDTO supplier = new SupplierDTO("Chaitanya", "Dehradun", "chaitanya@gmail.com", "9876543210", 7);
        //supplier.setId(1L);
        PartDTO part = new PartDTO(1L, "Gear", 10, 5);
        part.setId(1L);
        SupplierPartDTO supplierPartDTO = new SupplierPartDTO(supplier, part);
        ResponseEntity<SupplierPart> supplierPart = supplierController.addSupplier(supplierPartDTO);

        //get supplier of part
        ResponseEntity<List<SupplierPart>> supplierOfPart = supplierController.getSupplierOfPart(1L);
        assertEquals(1L, supplierOfPart.getBody().get(0).getPartId());
    }

    @Test
    void getAllSuppliers() {
        //adding supplier
        SupplierDTO supplier = new SupplierDTO("Chaitanya", "Dehradun", "chaitanya@gmail.com", "9876543210", 7);
        //supplier.setId(1L);
        PartDTO part = new PartDTO(1L, "Gear", 10, 5);
        part.setId(1L);
        SupplierPartDTO supplierPartDTO = new SupplierPartDTO(supplier, part);
        ResponseEntity<SupplierPart> supplierPart = supplierController.addSupplier(supplierPartDTO);

        //get All suppliers
        ResponseEntity<List<Supplier>> supplierList = supplierController.getAllSuppliers();
        assertEquals(1, supplierList.getBody().size());
    }
}