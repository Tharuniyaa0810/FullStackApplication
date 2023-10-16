package com.astrasquad.tharuniyaa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "_insightstable")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketInsights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String baseCurrency;
    private String quoteCurrency;
    private Double exchangeRate;
    private String insightChanges;
}
