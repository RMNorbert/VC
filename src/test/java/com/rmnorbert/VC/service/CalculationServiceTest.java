package com.rmnorbert.VC.service;

import com.rmnorbert.VC.dto.CalculationRequest;
import com.rmnorbert.VC.dto.CalculationResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationServiceTest {
    private CalculationService calculationService;

    @BeforeEach
    void setUp() {
        calculationService = new CalculationService();
    }

    @AfterEach
    void tearDown() {
        calculationService = null;
    }
    @Test
    void calculateAmountFromNet_WithValidInput_Test() {
        CalculationRequest request = new CalculationRequest(100, 1);
        CalculationResponse expected = new CalculationResponse(100,1,101);
        CalculationResponse actual = calculationService.calculateAmountFromNet(request);

        assertEquals(expected.valueAddedTax(), actual.valueAddedTax());
        assertEquals(expected.priceIncludingTax(), actual.priceIncludingTax());
    }

    @Test
    void calculateAmountFromNet_WithInValidInput_Test() {
        CalculationRequest request = new CalculationRequest(100, 1);
        CalculationResponse expected = new CalculationResponse(100,1,101);
        CalculationResponse actual = calculationService.calculateAmountFromNet(request);

        assertEquals(expected.valueAddedTax(), actual.valueAddedTax());
        assertEquals(expected.priceIncludingTax(), actual.priceIncludingTax());
    }

    @Test
    void calculateAmountFromGross_WithValidInput_Test() {
        CalculationRequest request = new CalculationRequest(100, 1);
        CalculationResponse expected = new CalculationResponse(99,1,100);
        CalculationResponse actual = calculationService.calculateAmountFromGross(request);

        assertEquals(expected.valueAddedTax(), actual.valueAddedTax());
        assertEquals(expected.priceWithoutVat(), actual.priceWithoutVat());
    }

    @Test
    void calculateAmountFromVat_WithValidInput_Test() {
        CalculationRequest request = new CalculationRequest(1, 1);
        CalculationResponse expected = new CalculationResponse(100,1,101);
        CalculationResponse actual = calculationService.calculateAmountFromVat(request);

        assertEquals(expected.priceWithoutVat(), actual.priceWithoutVat());
        assertEquals(expected.priceIncludingTax(), actual.priceIncludingTax());
    }
}