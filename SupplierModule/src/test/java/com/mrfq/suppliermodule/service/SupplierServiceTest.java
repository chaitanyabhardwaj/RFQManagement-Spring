package com.mrfq.suppliermodule.service;

import com.mrfq.suppliermodule.model.Supplier;
import com.mrfq.suppliermodule.repository.SupplierRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class SupplierServiceTest {

    @Mock
    private SupplierService supplierService;

    @Mock
    private SupplierRepo supplierRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addSupplier() {
        Supplier supplier = new Supplier("Chaitanya", "Dun", "chaitanyabhardwaj89@gmail.com", "8979676872", 10);
        supplierService.addSupplier(supplier);
        Mockito.when(supplierRepo.getById(1L)).thenReturn(supplier);
        String name = supplierRepo.getById(1L).getName();
        assertEquals(supplier.getName(), name);
    }

    @Test
    public void addSupplierNegative() throws Exception {
        Supplier supplier = new Supplier("Chaitanya", "Dun", "chaitanyabhardwaj89@gmail.com", "8979676872", 10);
        supplierService.addSupplier(supplier);
    }

    @Test
    void editSupplier() {
        Supplier supplier = new Supplier("Chaitanya", "Dun", "chaitanyabhardwaj89@gmail.com", "8979676872", 10);
        supplierService.editSupplier(supplier);
        Mockito.when(supplierRepo.getById(1L)).thenReturn(supplier);
        Supplier editedSupplier = supplierRepo.getById(1L);
        assertEquals(editedSupplier.getName(), supplier.getName());
    }

    @Test
    public void editSupplierNegative() throws Exception {
        Supplier supplier = new Supplier("Chaitanya", "Dun", "chaitanyabhardwaj89@gmail.com", "8979676872", 10);
        supplierService.editSupplier(supplier);
    }

    @Test
    void updateFeedback() {
        Supplier supplier = new Supplier();
        supplier.setId(1L);
        supplier.setFeedback(10);
        supplierService.updateFeedback(supplier);
        assertEquals(10, supplier.getFeedback());
    }

    @Test
    void updateFeedbackNegative() {
        Supplier supplier = new Supplier();
        supplier.setId(1L);
        supplier.setFeedback(50);
        supplierService.updateFeedback(supplier);
    }

}