package com.rmnorbert.VC.controller;

import com.rmnorbert.VC.dto.CalculationRequest;
import com.rmnorbert.VC.dto.CalculationResponse;
import com.rmnorbert.VC.service.CalculationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Calculate", description = "Calculation management APIs")
@RestController
@RequestMapping("/calculate")
public class CalculationController {
    private final CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @Operation(
            summary = "From the provided net and VAT amount returns the calculated price without VAT, value added tax and the price including tax ",
            description = "Returns a CalculationRequest calculated from the provided net and VAT amount, " +
                    "containing the calculated price without VAT, the value added tax and the price including tax",
            tags = {"Calculate", "post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returns the calculated results.",
                    content = {@Content(schema = @Schema(implementation = CalculationResponse.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid string input",
                    content = {@Content(schema = @Schema(implementation = String.class),
                            examples = @ExampleObject(
                                    value = "Invalid input value provided. Please provide a valid numeric value."),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400 ", description = "Invalid numeric input",
                    content = {@Content(schema = @Schema(implementation = String.class),
                            examples = @ExampleObject(
                                    value = "AMOUNT: must be greater than or equal to 1," +
                                            "VAT: must be greater than or equal to 1"),
                            mediaType = "application/json")})})
    @PostMapping("/net")
    public CalculationResponse calculateFromNetAmount(
            @RequestBody @Valid CalculationRequest request) {
        return calculationService.calculateAmountFromNet(request);
    }

    @Operation(
            summary = "From the provided gross and VAT amount returns the calculated price without VAT, value added tax and the price including tax",
            description = "Returns a CalculationRequest calculated from the provided gross and VAT amount, " +
                    "containing the calculated price without VAT, the value added tax and the price including tax",
            tags = {"Calculate", "post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returns the calculated results.",
                    content = {@Content(schema = @Schema(implementation = CalculationResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid string input",
                    content = {@Content(schema = @Schema(implementation = String.class),
                            examples = @ExampleObject(
                                    value = "Invalid input value provided. Please provide a valid numeric value."),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400 ", description = "Invalid numeric input",
                    content = {@Content(schema = @Schema(implementation = String.class),
                            examples = @ExampleObject(
                                    value = "AMOUNT: must be greater than or equal to 1," +
                                            "VAT: must be greater than or equal to 1"),
                            mediaType = "application/json")})})
    @PostMapping("/gross")
    public CalculationResponse calculateFromGrossAmount(@RequestBody @Valid CalculationRequest request) {
        return calculationService.calculateAmountFromGross(request);
    }

    @Operation(
            summary = "From the provided added tax and VAT amount returns the calculated price without VAT, value added tax and the price including tax",
            description = "Returns a CalculationRequest calculated from the provided added tax and VAT amount, " +
                    "containing the calculated price without VAT, the value added tax and the price including tax",
            tags = {"Calculate", "post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returns the calculated results.",
                    content = {@Content(schema = @Schema(implementation = CalculationResponse.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid string input",
                    content = {@Content(schema = @Schema(implementation = String.class),
                            examples = @ExampleObject(
                                    value = "Invalid input value provided. Please provide a valid numeric value."),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "400 ", description = "Invalid numeric input",
                    content = {@Content(schema = @Schema(implementation = String.class),
                            examples = @ExampleObject(
                                    value = "AMOUNT: must be greater than or equal to 1," +
                                            "VAT: must be greater than or equal to 1"),
                            mediaType = "application/json")})})
    @PostMapping("/vat")
    public CalculationResponse calculateFromVatAmount(@RequestBody @Valid CalculationRequest request) {
        return calculationService.calculateAmountFromVat(request);
    }
}
