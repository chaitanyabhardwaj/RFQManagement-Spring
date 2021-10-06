package com.mfpe.plantTest.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfpe.plant.model.Part;

@SpringBootTest(classes = PartTest.class)
class PartTest {
 
   private Part part = new Part();
 
 @Test
 void setPartIdTest() {
  part.setPartId(1);
  assertEquals(1, part.getPartId());
 }

 @Test
 void setPartDescriptionTest() {
  part.setPartDescription("ToolKit");
  assertEquals("ToolKit", part.getPartDescription());
 }

 @Test
 void setPartSpecificationTest() {
  part.setPartSpecification("10pieces");
  assertEquals("10pieces", part.getPartSpecification());
 }

 @Test
 void setStockInHandTest() {
  part.setStockInHand(100);
  assertEquals(100, part.getStockInHand());
 }

 

 @Test
 void getPartIdTest() {
  part.setPartId(1);
  assertEquals(1, part.getPartId());
 }

 @Test
 void getPartDescriptionTest() {
  part.setPartDescription("ToolKit");
  assertEquals("ToolKit", part.getPartDescription());
 }
 
 @Test
 void getPartSpecificationTest() {
  part.setPartSpecification("10pieces");
  assertEquals("10pieces", part.getPartSpecification());
 }
 
 @Test
 void getStockInHandTest() {
  part.setStockInHand(100);
  assertEquals(100, part.getStockInHand());
 }

}