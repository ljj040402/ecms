package com.ecms.repository;

import com.ecms.entity.SalesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SalesDataRepository extends JpaRepository<SalesData, Integer> {

    List<SalesData> findByMerchant_MerchantId(Integer merchantId);

    @Query("SELECT sd FROM SalesData sd WHERE sd.merchant.merchantId = :merchantId AND sd.salesDate BETWEEN :startDate AND :endDate")
    List<SalesData> findByMerchantAndDateRange(
            @Param("merchantId") Integer merchantId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
