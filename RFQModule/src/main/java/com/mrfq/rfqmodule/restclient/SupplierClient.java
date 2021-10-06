package com.mrfq.rfqmodule.restclient;

import com.mrfq.rfqmodule.model.Supplier;
import com.mrfq.rfqmodule.model.SupplierPart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("GATEWAY-SERVICE")
public interface SupplierClient {

    @GetMapping("/supplier/getSupplier/{supplierId}")
    Supplier getSupplier(@PathVariable Long supplierId);

    @GetMapping("/supplier/getSupplierOfPart/{partId}")
    List<SupplierPart> getSupplierOfPart(@PathVariable Long partId);

}
