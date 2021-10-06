package com.mrfq.fabricateapp.feign;

import com.mrfq.fabricateapp.dto.SupplierDTO;
import com.mrfq.fabricateapp.dto.SupplierPartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("GATEWAY-SERVICE")
public interface SupplierClient {

    @GetMapping("/supplier/getSupplier/{id}")
    SupplierDTO getSupplier(Long id);

    @PostMapping("/supplier/addSupplier")
    SupplierDTO addSupplier(@RequestBody SupplierPartDTO dto);

    @PostMapping("/supplier/editSupplier")
    SupplierDTO editSupplier(@RequestBody SupplierDTO dto);

    @PostMapping("/supplier/updateFeedback")
    String updateFeedback(@RequestBody SupplierDTO dto);

    @GetMapping("/supplier/getAllSuppliers")
    List<SupplierDTO> getAllSuppliers();

}
