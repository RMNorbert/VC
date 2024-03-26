package com.rmnorbert.VC.dto;

import jakarta.validation.constraints.Min;

public record CalculationResponse(
        @Min(1)
        double priceWithoutVat,
        @Min(1)

        double valueAddedTax,
        @Min(1)

        double priceIncludingTax) {
}
