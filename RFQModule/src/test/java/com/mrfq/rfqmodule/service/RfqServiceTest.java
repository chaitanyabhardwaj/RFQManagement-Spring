package com.mrfq.rfqmodule.service;

import com.mrfq.rfqmodule.model.Part;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class RfqServiceTest {

    @Mock
    private RfqService rfqService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getRfqOfPlant() {

    }

    @Test
    void getRfqDetails() {
    }

    @Test
    void getPotentialVendorsOfRfq() {
    }
}