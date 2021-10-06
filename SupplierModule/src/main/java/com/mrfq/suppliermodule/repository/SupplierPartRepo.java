package com.mrfq.suppliermodule.repository;

import com.mrfq.suppliermodule.model.SupplierPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierPartRepo extends JpaRepository<SupplierPart, Long> {

    List<SupplierPart> findSupplierPartByPartId(Long partId);

}
