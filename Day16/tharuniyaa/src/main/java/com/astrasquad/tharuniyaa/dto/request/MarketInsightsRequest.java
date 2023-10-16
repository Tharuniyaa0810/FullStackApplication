package com.astrasquad.tharuniyaa.dto.request;

import lombok.Data;

@Data
public class MarketInsightsRequest {
    private String baseCurrency;
    private String quoteCurrency;
    private Double exchangeRate;
    private String insightChanges;

    // Add constructors, getters, and setters as needed
}
