package com.mrfq.suppliermodule.service;

import com.mrfq.suppliermodule.model.Supplier;
import com.mrfq.suppliermodule.model.SupplierPart;
import com.mrfq.suppliermodule.repository.SupplierPartRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SupplierPartServiceTest {

    @InjectMocks
    private SupplierPartService supplierPartService;

    @Mock
    private SupplierPartRepo supplierPartRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addSupplierPart() {
        SupplierPart supplierPart = new SupplierPart(1L, 1L, "Engine", 10, 5);
        supplierPartService.addSupplierPart(supplierPart);
        Mockito.when(supplierPartRepo.getById(1L)).thenReturn(supplierPart);
        String name = supplierPartRepo.getById(1L).getPartName();
        assertEquals(supplierPart.getPartName(), name);
    }

    @Test
    public void getSupplierOfPart() {
        List<SupplierPart> demoList = new ArrayList<>();
        SupplierPart supplierPart1 = new SupplierPart(1L, 1L, "Engine", 10, 5);
        SupplierPart supplierPart2 = new SupplierPart(1L, 2L, "Engine", 8, 3);
        demoList.add(supplierPart1);
        demoList.add(supplierPart2);
        Mockito.when(supplierPartService.getSupplierOfPart(1L)).thenReturn(demoList);
        List<SupplierPart> supplierList = supplierPartService.getSupplierOfPart(1L);
        assertEquals(2, supplierList.size());
    }
}