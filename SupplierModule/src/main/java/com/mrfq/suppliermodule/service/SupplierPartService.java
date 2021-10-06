package com.mrfq.suppliermodule.service;

import com.mrfq.suppliermodule.model.SupplierPart;
import com.mrfq.suppliermodule.repository.SupplierPartRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SupplierPartService {

    final private SupplierPartRepo supplierPartRepo;

    public SupplierPartService(SupplierPartRepo supplierPartRepo) {
        this.supplierPartRepo = supplierPartRepo;
    }

    public SupplierPart addSupplierPart(SupplierPart supplierPart) {
        return supplierPartRepo.save(supplierPart);
    }

    public List<SupplierPart> findAll(){
        return supplierPartRepo.findAll();
    }

    public List<SupplierPart> getSupplierOfPart(Long partId) {
        return supplierPartRepo.findSupplierPartByPartId(partId);
    }

    /* UTILITY FUNCTIONS */
    public SupplierPart toSupplierPart(SupplierPart part) {
        SupplierPart supplierPart = new SupplierPart();
        supplierPart.setPartId(part.getPartId());
        supplierPart.setSupplierId(part.getSupplierId());
        supplierPart.setPartName(part.getPartName());
        supplierPart.setQuantity(part.getQuantity());
        supplierPart.setTimePeriod(part.getTimePeriod());
        return supplierPart;
    }

}