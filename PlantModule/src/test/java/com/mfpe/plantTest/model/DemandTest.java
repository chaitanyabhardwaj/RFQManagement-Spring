package com.mfpe.plantTest.model;

 

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.plant.model.Demand;

 


@SpringBootTest(classes = DemandTest.class)
class DemandTest {
    
    
    private Demand demand = new Demand();
    
    @Test
    void setDemandIdTest() {
        demand.setDemandId(1);
        assertEquals(1, demand.getDemandId());
    }
    
    @Test
    void setPartIdTest() {
        demand.setPartId(1);
        assertEquals(1, demand.getPartId());
    }
    
    @Test
    void setDemandCountTest() {
        demand.setDemandCount(70);
        assertEquals(70,demand.getDemandCount());
    }
    @Test
    void getDemandIdTest() {
        demand.setDemandId(1);
        assertEquals(1, demand.getDemandId());
    }
    
    @Test
    void getPartIdTest() {
        demand.setPartId(1);
        assertEquals(1, demand.getPartId());
    }
    
    
    @Test
    void getDemandCountTest() {
        demand.setDemandCount(70);
        assertEquals(70, demand.getDemandCount());
    }
    
    
}