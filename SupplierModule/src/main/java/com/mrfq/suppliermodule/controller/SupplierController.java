package com.mrfq.suppliermodule.controller;

import com.mrfq.suppliermodule.model.*;
import com.mrfq.suppliermodule.service.SupplierPartService;
import com.mrfq.suppliermodule.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierPartService supplierPartService;

    @PostMapping("/addSupplier")
    public ResponseEntity<SupplierPart> addSupplier(@RequestBody SupplierPartDTO dto) {
        //Separate DTOs
        SupplierDTO supplierDTO = dto.getSupplierObj();
        PartDTO partDTO = dto.getPartObj();

        //Entities creation
        Supplier supplier = new Supplier();
        SupplierPart supplierPart = new SupplierPart();

        //supplier entity
        supplier.setName(supplierDTO.getName());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setLocation(supplierDTO.getLocation());
        supplier.setPhone(supplierDTO.getPhone());
        supplier.setFeedback(supplierDTO.getFeedback());

        //supplierpart entity
        supplierPart.setPartId(partDTO.getPartId());
        supplierPart.setPartName(partDTO.getName());
        supplierPart.setQuantity(partDTO.getQuantity());
        supplierPart.setTimePeriod(partDTO.getTimePeriod());

        //call supplierservice to add supplier to the repo
        //fetch the supplier id
        Long supplierId = supplierService.addSupplier(supplier).getId();

        //set supplier id for supplierpart
        supplierPart.setSupplierId(supplierId);

        //call supplierpartservice to add supplierpart to the repo
        supplierPartService.addSupplierPart(supplierPart);
        return new ResponseEntity<>(supplierPart, HttpStatus.OK);
    }

    @GetMapping("/getSupplier/{supplierId}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable Long supplierId) {
        Supplier supplier = supplierService.getSupplier(supplierId);
        if(supplier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @PostMapping("/editSupplier")
    public ResponseEntity<Supplier> editSupplier(@RequestBody SupplierDTO dto) {
        try {
            Supplier supplier = new Supplier();
            supplier.setId(dto.getId());
            supplier.setName(dto.getName());
            supplier.setEmail(dto.getEmail());
            supplier.setLocation(dto.getLocation());
            supplier.setPhone(dto.getPhone());
            supplier.setFeedback(dto.getFeedback());
            supplierService.editSupplier(supplier);
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        }
        catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/updateFeedback")
    public ResponseEntity<String> updateFeedback(@RequestBody SupplierDTO dto) {
        try {
            Supplier supplier = new Supplier();
            supplier.setId(dto.getId());
            supplier.setFeedback(dto.getFeedback());
            supplierService.updateFeedback(supplier);
            return new ResponseEntity<>("Supplier ID: " + dto.getId() + "\nUpdated feedback: " +
                    dto.getFeedback(), HttpStatus.OK);
        }
        catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Supplier Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getSupplierOfPart/{partId}")
    public ResponseEntity<List<SupplierPart>> getSupplierOfPart(@PathVariable Long partId) {
        try {
            log.debug("Into controller - Get Supplier Of Part");
            log.debug(partId + "");
            List<SupplierPart> supplierPartList = supplierPartService.getSupplierOfPart(partId);
            return new ResponseEntity<>(supplierPartList, HttpStatus.OK);
        }
        catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllSuppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> supplierList = supplierService.getAllSupplier();
        return new ResponseEntity<>(supplierList, HttpStatus.OK);
    }


}
