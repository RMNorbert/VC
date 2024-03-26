package com.rmnorbert.VC.service;

import com.rmnorbert.VC.dto.CalculationRequest;
import com.rmnorbert.VC.dto.CalculationResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public CalculationResponse calculateAmountFromNet(CalculationRequest request) {
        double tax = calculateAddedTaxFromNet(request.amount(), request.vat());
        double gross = request.amount() + tax;
        return new CalculationResponse(request.amount(), tax, gross);
    }

    public CalculationResponse calculateAmountFromGross(CalculationRequest request) {
        double tax = calculateAddedTaxFromGross(request.amount(), request.vat());
        double net = request.amount() - tax;
        return new CalculationResponse(net, tax, request.amount());
    }

    public CalculationResponse calculateAmountFromVat(CalculationRequest request) {
        double net = calculateNetFromTax(request.amount(), request.vat());
        double gross = net + request.amount();
        return new CalculationResponse(net, request.amount(), gross);
    }

    private double calculateNetFromTax(double tax, double VAT) {
        return tax / (VAT / 100);
    }

    private double calculateAddedTaxFromNet(double net, double VAT) {
        return net * (VAT / 100);
    }

    private double calculateAddedTaxFromGross(double gross, double VAT) {
        return gross * (VAT / 100);
    }

}
