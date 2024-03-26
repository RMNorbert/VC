package com.rmnorbert.VC.service;

import com.rmnorbert.VC.dto.VatRateListResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VatRateServiceTest {
    private VatRateService vatRateService;

    @BeforeEach
    void setUp() {
        vatRateService = new VatRateService();
    }
    @AfterEach
    void tearDown() {
        vatRateService = null;
    }
    @ParameterizedTest
    @MethodSource("vatRatesProvider")
    void getVatRatesShouldReturnExpectedValue(int expectedRate, int indexToAssert) {
        VatRateListResponse actual = vatRateService.getVatRates();
        assertEquals(expectedRate, actual.vatRateList().get(indexToAssert));
    }

    private static Stream<Arguments> vatRatesProvider() {
        return Stream.of(
                Arguments.of(10, 0),
                Arguments.of(13, 1),
                Arguments.of(20, 2)
        );
    }
}