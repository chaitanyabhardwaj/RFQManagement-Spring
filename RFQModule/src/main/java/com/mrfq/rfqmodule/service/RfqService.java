package com.mrfq.rfqmodule.service;

import com.mrfq.rfqmodule.model.*;
import com.mrfq.rfqmodule.repository.RfqDetailRepo;
import com.mrfq.rfqmodule.repository.RfqRepo;
import com.mrfq.rfqmodule.restclient.PartClient;
import com.mrfq.rfqmodule.restclient.SupplierClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class RfqService {

    final private RfqRepo rfqRepo;
    final private RfqDetailRepo rfqDetailRepo;
    final private SupplierClient supplierClient;
    final private PartClient partClient;

    public RfqService(RfqRepo rfqRepo, RfqDetailRepo rfqDetailRepo, SupplierClient supplierClient, PartClient partClient) {
        this.rfqRepo = rfqRepo;
        this.rfqDetailRepo = rfqDetailRepo;
        this.supplierClient = supplierClient;
        this.partClient = partClient;
    }

    public Rfq getRfqOfPlant(Long partId) {
        //fetch part
        Part part = partClient.getPartById(partId);
        //fetch suppliers
        List<SupplierPart> suppliersList = supplierClient.getSupplierOfPart(partId);
        //create rfq
        Rfq rfq = new Rfq(partId);
        final Long rfqId = rfqRepo.save(rfq).getId();
        final Long demandId = partClient.getDemandIdByPartId(partId);
        RfqDetail rfqDetail;
        for(SupplierPart supplierPart : suppliersList) {
            LocalDate expectedDate = LocalDate.now().plusDays(supplierPart.getTimePeriod());
            Date date = Date.valueOf(expectedDate);
            rfqDetail = new RfqDetail(rfqId, partId, supplierPart.getSupplierId(), part.getPartDescription(), demandId, date, part.getPartSpecification(), part.getStockInHand());
            rfqDetailRepo.save(rfqDetail);
        }
        return rfq;
    }

    public List<RfqDetail> getRfqDetails(Long rfqId) {
        return rfqDetailRepo.getRfqDetailsByRfqId(rfqId);
    }

    public List<Supplier> getPotentialVendorsOfRfq(Long rfqId) {
        List<RfqDetail> rfqDetailList = rfqDetailRepo.getRfqDetailsByRfqId(rfqId);
        List<Supplier> supplierList = new ArrayList<>();
        Long supplierId;
        Supplier supplier;
        for(RfqDetail detail : rfqDetailList) {
            supplierId = detail.getSupplierId();
            supplier = supplierClient.getSupplier(supplierId);
            if(supplier.getFeedback() >= 7)
                supplierList.add(supplier);
        }
        return supplierList;
    }

}
