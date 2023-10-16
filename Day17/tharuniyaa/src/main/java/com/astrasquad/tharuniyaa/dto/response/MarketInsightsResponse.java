package com.astrasquad.tharuniyaa.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
@Data
public class MarketInsightsResponse {
    private Integer id;
    private String baseCurrency;
    private String quoteCurrency;
    private Double exchangeRate;
    private String insightChanges;

    // Add constructors, getters, and setters as needed
}
