package com.mfpe.plantTest.model;

 

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.plant.model.ReorderRules;

 


@SpringBootTest(classes = ReorderRulesTest.class)
class ReorderRulesTest {
    
    
    private ReorderRules rr = new ReorderRules();
    
    
    @Test
    void setPartIdTest() {
        rr.setPartId(1);
        assertEquals(1, rr.getPartId());
    }
    
    
    @Test
    void setDemandIdTest() {
        rr.setDemandId(1);
        assertEquals(1, rr.getDemandId());
    }
    
    @Test
    void setMinQuantityTest() {
        rr.setMinQuantity(20);
        assertEquals(20, rr.getMinQuantity());
    }
    
    @Test
    void setMaxQuantityTest() {
        rr.setMaxQuantity(60);
        assertEquals(60, rr.getMaxQuantity());
    }
    
    @Test
    void setReorderFrequencyTest() {
        rr.setReorderFrequency(50);
        assertEquals(50, rr.getReorderFrequency());
    }
    
    @Test
    void getPartIdTest() {
        rr.setPartId(1);
        assertEquals(1, rr.getPartId());
    }
    
    @Test
    void geDemandIdTest() {
        rr.setDemandId(1);
        assertEquals(1, rr.getDemandId());
    }
    
    @Test
    void getMinQuantityTest() {
        rr.setMinQuantity(20);
        assertEquals(20, rr.getMinQuantity());
    }
    

 

    @Test
    void getMaxQuantityTest() {
        rr.setMaxQuantity(60);
        assertEquals(60, rr.getMaxQuantity());
    }
    

 

    @Test
    void getReorderFrequencyTest() {
        rr.setReorderFrequency(50);
        assertEquals(50, rr.getReorderFrequency());
    }
}
    