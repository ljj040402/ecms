package com.ecms.controller;

import com.ecms.entity.SalesData;
import com.ecms.service.SalesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sales-data")
@CrossOrigin(origins = "http://localhost:8081")
public class SalesDataController {

    @Autowired
    private SalesDataService salesDataService;

    @GetMapping("/merchant/{merchantId}")
    public ResponseEntity<List<SalesData>> getSalesDataByMerchant(
            @PathVariable Integer merchantId) {
        List<SalesData> salesData = salesDataService.getSalesDataByMerchant(merchantId);
        return ResponseEntity.ok(salesData);
    }

    @GetMapping("/merchant/{merchantId}/date-range")
    public ResponseEntity<List<SalesData>> getSalesDataByDateRange(
            @PathVariable Integer merchantId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<SalesData> salesData = salesDataService.getSalesDataByMerchantAndDateRange(
                merchantId, startDate, endDate);
        return ResponseEntity.ok(salesData);
    }

    @PostMapping
    public ResponseEntity<SalesData> createSalesData(@RequestBody SalesData salesData) {
        SalesData savedData = salesDataService.saveSalesData(salesData);
        return ResponseEntity.ok(savedData);
    }
}
