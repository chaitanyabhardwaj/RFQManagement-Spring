package com.mrfq.suppliermodule.service;

import com.mrfq.suppliermodule.model.Supplier;
import com.mrfq.suppliermodule.repository.SupplierRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    final private SupplierRepo supplierRepo;

    public SupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public Supplier editSupplier(Supplier supplier) {
        Supplier editSupplier = supplierRepo.getById(supplier.getId());
        editSupplier.setName(supplier.getName());
        editSupplier.setEmail(supplier.getEmail());
        editSupplier.setPhone(supplier.getPhone());
        editSupplier.setLocation(supplier.getLocation());
        editSupplier.setFeedback(supplier.getFeedback());
        return supplierRepo.save(editSupplier);
    }

    public void updateFeedback(Supplier supplier) {
        Supplier editSupplier = supplierRepo.getById(supplier.getId());
        editSupplier.setFeedback(supplier.getFeedback());
        supplierRepo.save(editSupplier);
    }

    public Supplier getSupplier(Long supplierId) {
        return toSupplier(supplierRepo.getById(supplierId));
    }

    public List<Supplier> getAllSupplier() {
        return supplierRepo.findAll();
    }

    /* UTILITY FUNCTIONS */
    public Supplier toSupplier(Supplier supplier) {
        Supplier supplier1 = new Supplier();
        supplier1.setId(supplier.getId());
        supplier1.setName(supplier.getName());
        supplier1.setEmail(supplier.getEmail());
        supplier1.setPhone(supplier.getPhone());
        supplier1.setLocation(supplier.getLocation());
        supplier1.setFeedback(supplier.getFeedback());
        return supplier1;
    }

}
