package com.astrasquad.tharuniyaa.service;

import com.astrasquad.tharuniyaa.model.MarketInsights;

import java.util.List;
public interface MarketInsightsService {
    MarketInsights getMarketInsights(String baseCurrency, String quoteCurrency);

    List<MarketInsights> getAllMarketInsights();

  

    MarketInsights createMarketInsights(MarketInsights marketInsights);

    MarketInsights updateMarketInsights(Integer id, MarketInsights marketInsights);

    void deleteMarketInsights(Integer id);

    // Other service methods for CRUD operations
}

