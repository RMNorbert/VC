package com.rmnorbert.VC.service;

import com.rmnorbert.VC.dto.VatRateListResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VatRateService {
    private static final ArrayList<Integer> AUSTRIAN_VAT_RATES = new ArrayList<>(List.of(10, 13, 20));
    public VatRateListResponse getVatRates() {
        return new VatRateListResponse(AUSTRIAN_VAT_RATES);
    }
}
