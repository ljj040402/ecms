package com.ecms.service;

import com.ecms.entity.SalesData;
import com.ecms.repository.SalesDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalesDataService {

    @Autowired
    private SalesDataRepository salesDataRepository;

    public List<SalesData> getSalesDataByMerchant(Integer merchantId) {
        return salesDataRepository.findByMerchant_MerchantId(merchantId);
    }

    public List<SalesData> getSalesDataByMerchantAndDateRange(
            Integer merchantId,
            LocalDate startDate,
            LocalDate endDate) {
        return salesDataRepository.findByMerchantAndDateRange(merchantId, startDate, endDate);
    }

    public SalesData saveSalesData(SalesData salesData) {
        return salesDataRepository.save(salesData);
    }
}
