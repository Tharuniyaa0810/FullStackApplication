package com.astrasquad.tharuniyaa.repository;

import com.astrasquad.tharuniyaa.model.MarketInsights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketInsightsRepository extends JpaRepository<MarketInsights, Integer> {

    MarketInsights findByBaseCurrencyAndQuoteCurrency(String baseCurrency, String quoteCurrency);

	

    // Other query methods if required
}
