package com.astrasquad.tharuniyaa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrasquad.tharuniyaa.model.MarketInsights;
import com.astrasquad.tharuniyaa.repository.MarketInsightsRepository;
import com.astrasquad.tharuniyaa.service.MarketInsightsService;

@Service
public class MarketInsightsServiceImpl implements MarketInsightsService {

    @Autowired
    private MarketInsightsRepository marketInsightsRepository;

    @Override
    public MarketInsights getMarketInsights(String baseCurrency, String quoteCurrency) {
        return marketInsightsRepository.findByBaseCurrencyAndQuoteCurrency(baseCurrency, quoteCurrency);
    }

    @Override
    public List<MarketInsights> getAllMarketInsights() {
        return marketInsightsRepository.findAll();
    }

   

    @Override
    public MarketInsights createMarketInsights(MarketInsights marketInsights) {
        return marketInsightsRepository.save(marketInsights);
    }

    @Override
    public MarketInsights updateMarketInsights(Integer id, MarketInsights marketInsights) {
        if (marketInsightsRepository.existsById(id)) {
            marketInsights.setId(id);
            return marketInsightsRepository.save(marketInsights);
        }
        return null; // Handle the case where the resource is not found
    }

    @Override
    public void deleteMarketInsights(Integer id) {
        marketInsightsRepository.deleteById(id);
    }

    // Other methods and business logic
}
