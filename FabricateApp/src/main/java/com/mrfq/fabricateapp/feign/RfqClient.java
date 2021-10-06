package com.mrfq.fabricateapp.feign;

import com.mrfq.fabricateapp.dto.Rfq;
import com.mrfq.fabricateapp.dto.RfqDetail;
import com.mrfq.fabricateapp.dto.SupplierDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import java.util.List;

@FeignClient("GATEWAY-SERVICE")
public interface RfqClient {

    @GetMapping("/rfq/getRFQOfPlant/{partId}")
    Rfq getRfqOfPlant(@PathVariable Long partId);

    @GetMapping("/rfq/getRfqDetails/{rfqId}")
    List<RfqDetail> getRfqDetail(@PathVariable Long rfqId);

    @GetMapping("/rfq/getPotentialVendorsOfRFQ/{rfqId}")
    ResponseEntity<List<SupplierDTO>> getPotentialVendorsOfRfq(@PathVariable Long rfqId);

}
