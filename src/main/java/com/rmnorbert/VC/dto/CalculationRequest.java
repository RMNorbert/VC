package com.rmnorbert.VC.dto;

import jakarta.validation.constraints.Min;

public record CalculationRequest(@Min(1)
                                 double amount,
                                 @Min(1)
                                 double vat) {
}
