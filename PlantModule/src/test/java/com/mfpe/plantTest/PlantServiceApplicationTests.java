package com.mfpe.plantTest;

 

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.mfpe.plant.model.Demand;
import com.mfpe.plant.model.Part;
import com.mfpe.plant.model.PlantReorderDetails;
import com.mfpe.plant.model.ReorderRules;
import com.mfpe.plant.repos.DemandRepository;
import com.mfpe.plant.repos.PartRepository;
import com.mfpe.plant.repos.PlantReorderDetailsRepository;
import com.mfpe.plant.repos.ReorderRulesRepository;
import com.mfpe.plant.service.PlantService;

 

@SpringBootTest(classes={PlantServiceApplicationTests.class})
@ContextConfiguration
class PlantServiceApplicationTests {

    @InjectMocks
    private PlantService plantService;
    @Mock
    private ReorderRulesRepository reorderRulesRepository;
    @Mock
    private PartRepository partRepository;
    @Mock
    private DemandRepository demandRepository;
    @Mock
    private PlantReorderDetailsRepository plantReorderDetailsRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByPartIdPositiveTest() {
        ReorderRules reorderRulesactual = new ReorderRules(1, 1, 10, 20, 100);
        Mockito.when(reorderRulesRepository.findByPartId(1)).thenReturn(reorderRulesactual);
        ReorderRules reorderRulesexpected = plantService.findById(1);
        assertEquals(reorderRulesexpected, reorderRulesactual);
    }

    @Test
    public void findByPartIdNegativeTest() {
        ReorderRules reorderRulesactual = new ReorderRules(1, 1, 10, 20, 100);
        Mockito.when(reorderRulesRepository.findByPartId(1)).thenReturn(reorderRulesactual);
        ReorderRules reorderRulesexpected = plantService.findById(null);
        assertNotEquals(reorderRulesexpected, reorderRulesactual);
    }

    @Test
    public void viewStockInHandPositiveTest() {
        Part partActual = new Part(1, "Diode", "20cm", 10);
        Mockito.when(partRepository.viewStockInHand(1)).thenReturn(partActual);
        Part partExpected = plantService.viewStockInHand(1);
        assertEquals(partExpected, partActual);
    }

    @Test
    public void viewStockInHandNegativeTest() {
        Part partActual = new Part(1, "Diode", "20cm", 10);
        Mockito.when(partRepository.viewStockInHand(1)).thenReturn(partActual);
        Part partExpected = plantService.viewStockInHand(0);
        assertNotEquals(partExpected, partActual);
    }
    
    @Test
    public void findAllPartsInReorderTest() {
         String str="2015-03-31";  
         Date date=Date.valueOf(str);
        List<PlantReorderDetails> list = new ArrayList<PlantReorderDetails>();
        PlantReorderDetails rd1 = new PlantReorderDetails(1,"Approved",date);
        PlantReorderDetails rd2 = new PlantReorderDetails(1,"Pending",date);
        list.add(rd1);
        list.add(rd2);
        when(plantReorderDetailsRepository.findAll()).thenReturn(list);
        List<PlantReorderDetails> rulesDetailsList = plantService.findAllPartsInReorder();
        assertEquals(1, rulesDetailsList.size());
    }

    @Test
    public void findAllPartsInReorderNegativeTest() {
        String str="2015-03-31";  
         Date date=Date.valueOf(str);
        List<PlantReorderDetails> list = new ArrayList<PlantReorderDetails>();
        PlantReorderDetails rd1 = new PlantReorderDetails(1,"Approved",date);
        PlantReorderDetails rd2 = new PlantReorderDetails(1,"Pending",date);
        list.add(rd1);
        list.add(rd2);
        when(plantReorderDetailsRepository.findAll()).thenReturn(list);
        List<PlantReorderDetails> rulesDetailsList = plantService.findAllPartsInReorder();
        assertNotEquals(2, rulesDetailsList.size());
    }
    
    @Test
    public void findAllPartsInReorderNullTest() {
//        String str="2015-03-31";  
//         Date date=Date.valueOf(str);
        List<PlantReorderDetails> list = new ArrayList<PlantReorderDetails>();
//        PlantReorderDetails rd1 = new PlantReorderDetails(1,"Approved",date);
//        PlantReorderDetails rd2 = new PlantReorderDetails(1,"Pending",date);
//        list.add(rd1);
//        list.add(rd2);
        when(plantReorderDetailsRepository.findAll()).thenReturn(list);
        List<PlantReorderDetails> rulesDetailsList = plantService.findAllPartsInReorder();
        assertEquals(list.isEmpty(), rulesDetailsList.isEmpty());
    }


 

//    @Test
//    public void findAllTest() {
//        ReorderRules reorderRulesactual = new ReorderRules(1, 1, 10, 20, 100);
//        reorderRulesRepository.save(reorderRulesactual);
//        List<Part> partActual1 = partRepository.findAll();
//        List<Part> partExpected = plantService.findAll();
//        assertEquals(partExpected, partActual1);
//    }

    @Test
    public void saveReorderRulesTest() {
        ReorderRules reorderRules = new ReorderRules(1, 1, 10, 20, 100);
        reorderRulesRepository.save(reorderRules);
        assertThat(reorderRules.getPartId()).isGreaterThan(0);
    }

    @Test
    public void saveReorderRulesNegativeTest() {
        ReorderRules reorderRules = new ReorderRules();
        reorderRulesRepository.save(reorderRules);
        assertThat(reorderRules.getPartId()).isEqualTo(null);
    }

    @Test
    public void findByDemandIdPositiveTest() {
         String str="2015-03-31";  
         Date date=Date.valueOf(str);
         Demand demand = new Demand(1, 1, 100, date);
         Optional<Demand> demandActual = Optional.of(demand);
        Mockito.when(demandRepository.findById(1)).thenReturn(demandActual);
        Optional<Demand> demandExpected = plantService.findByDemandId(1);
        assertEquals(demandExpected, demandActual);
    }

    @Test
    public void findByDemandIdNegativeTest() {
         String str="2015-03-31";  
         Date date=Date.valueOf(str);
         Demand demand = new Demand(1, 1, 100, date);
         Optional<Demand> demandActual = Optional.of(demand);
        Mockito.when(demandRepository.findById(1)).thenReturn(demandActual);
        Optional<Demand> demandExpected = plantService.findByDemandId(null);
        assertNotEquals(demandExpected, demandActual);
    }
    
    @Test
    public void saveReorderDetailsTest() {
    	  String str="2015-03-31";  
          Date date=Date.valueOf(str);
        PlantReorderDetails reorderDetails = new PlantReorderDetails(1, "pending",date);
        plantReorderDetailsRepository.save(reorderDetails);
        assertThat(reorderDetails.getPartId()).isGreaterThan(0);
    }

    @Test
    public void saveReorderDetailsNegativeTest() {
       PlantReorderDetails reorderDetails = new PlantReorderDetails();
       plantReorderDetailsRepository.save(reorderDetails);
        assertThat(reorderDetails.getPartId()).isEqualTo(null);
    }
    
    @Test
    public void findAllReorderRulesTest() {
        List<ReorderRules> list = new ArrayList<ReorderRules>();
        ReorderRules rr1 = new ReorderRules(1,1,20,60,40);
        ReorderRules rr2 = new ReorderRules(2,2,12,25,13);
        list.add(rr1);
        list.add(rr2);
        when(reorderRulesRepository.findAll()).thenReturn(list);
        List<ReorderRules> reorderRulesList = plantService.findAllReorderRules();
        assertEquals(2,  reorderRulesList.size());
    }

    @Test
    public void findAllReorderRulesNegativeTest() {
        List<ReorderRules> list = new ArrayList<ReorderRules>();
        ReorderRules rr1 = new ReorderRules(1,1,20,60,40);
        ReorderRules rr2 = new ReorderRules(2,2,12,25,13);
        list.add(rr1);
        list.add(rr2);
        when(reorderRulesRepository.findAll()).thenReturn(list);
        List<ReorderRules> reorderRulesList = plantService.findAllReorderRules();
        assertNotEquals(3,  reorderRulesList.size());
    }
    
    @Test
    public void findByPartIdUsingDemandPositiveTest() {
    	  String str="2015-03-31";  
          Date date=Date.valueOf(str);
        Demand demand = new Demand(1, 1, 10, date);
        List<Integer> listActual = new ArrayList<Integer>();
        listActual.add(1);
        Mockito.when(demandRepository.findAllPartId()).thenReturn(listActual);
        List<Integer> listExpected = plantService.findAllPartId();
        assertEquals(listActual,listExpected);
    }

//    @Test
//    public void findByPartIdUsingDemandNegativeTest() {
//        ReorderRules reorderRulesactual = new ReorderRules(1, 1, 10, 20, 100);
//        Mockito.when(reorderRulesRepository.findByPartId(1)).thenReturn(reorderRulesactual);
//        ReorderRules reorderRulesexpected = plantService.findById(null);
//        assertNotEquals(reorderRulesexpected, reorderRulesactual);
//    }

}