package com.mrfq.suppliermodule.repository;

import com.mrfq.suppliermodule.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {
}
