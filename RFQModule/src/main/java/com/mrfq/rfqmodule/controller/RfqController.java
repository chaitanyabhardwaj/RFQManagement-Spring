package com.mrfq.rfqmodule.controller;

import com.mrfq.rfqmodule.model.*;
import com.mrfq.rfqmodule.service.RfqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rfq")
public class RfqController {

    @Autowired
    RfqService rfqService;

    @GetMapping("/getRFQOfPlant/{partId}")
    public ResponseEntity<Rfq> getRfqOfPlant(@PathVariable Long partId) {
        Rfq rfq = rfqService.getRfqOfPlant(partId);
        return new ResponseEntity<>(rfq, HttpStatus.OK);
    }

    @GetMapping("/getRfqDetails/{rfqId}")
    public ResponseEntity<List<RfqDetail>> getRfqDetail(@PathVariable Long rfqId) {
        List<RfqDetail> rfqDetailList = rfqService.getRfqDetails(rfqId);
        if(rfqDetailList == null || rfqDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rfqDetailList, HttpStatus.OK);
    }

    @GetMapping("/getPotentialVendorsOfRFQ/{rfqId}")
    public ResponseEntity<List<Supplier>> getPotentialVendorsOfRfq(@PathVariable Long rfqId) {
        List<Supplier> supplierList = rfqService.getPotentialVendorsOfRfq(rfqId);
        if(supplierList == null || supplierList.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(supplierList, HttpStatus.OK);
    }

}
