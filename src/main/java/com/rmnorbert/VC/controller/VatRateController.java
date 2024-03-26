package com.rmnorbert.VC.controller;

import com.rmnorbert.VC.dto.VatRateListResponse;
import com.rmnorbert.VC.service.VatRateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "VAT", description = "VAT management APIs")
@RestController
@RequestMapping("/vat")
public class VatRateController {
    private final VatRateService vatRateService;

    @Autowired
    public VatRateController(VatRateService vatRateService) {
        this.vatRateService = vatRateService;
    }

    @Operation(
            summary = "Currently returns only the Austrian VAT rates",
            description = "Returns a VatRateListResponse containing the Austrian VAT rates, " +
                    "this will be replaced with external API to provide actual rates",
            tags = {"VAT", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returns the Austrian VAT rates.",
                    content = {@Content(schema = @Schema(implementation = VatRateListResponse.class),
                            mediaType = "application/json")})})
    @GetMapping("/")
    public VatRateListResponse getVatRates() {
        return vatRateService.getVatRates();
    }
}
