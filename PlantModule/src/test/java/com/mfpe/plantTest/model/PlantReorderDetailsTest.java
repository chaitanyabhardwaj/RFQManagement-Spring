package com.mfpe.plantTest.model;

 

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.plant.model.PlantReorderDetails;

 


@SpringBootTest(classes = PlantReorderDetailsTest.class)
class PlantReorderDetailsTest {
    
    
    private PlantReorderDetails prd = new PlantReorderDetails();
    
    
    @Test
    void setPartIdTest() {
        prd.setPartId(1);
        assertEquals(1, prd.getPartId());
    }
     
    @Test
    void setReorderStatusTest() {
        prd.setReorderStatus("approved");
        assertEquals("approved", prd.getReorderStatus());
    }
    
    @Test
    void getPartIdTest() {
        prd.setPartId(1);
        assertEquals(1, prd.getPartId());
    }
    
    @Test
    void getReorderStatusTest() {
        prd.setReorderStatus("approved");
        assertEquals("approved", prd.getReorderStatus());
    }

 

    
}