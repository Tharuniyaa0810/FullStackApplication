package com.astrasquad.tharuniyaa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.astrasquad.tharuniyaa.model.MarketInsights;
import com.astrasquad.tharuniyaa.service.MarketInsightsService;

@RestController
@RequestMapping("/market-insights")
public class MarketInsightsController {

    @Autowired
    private MarketInsightsService marketInsightsService;

    @GetMapping("/{baseCurrency}/{quoteCurrency}")
    public MarketInsights getMarketInsights(@PathVariable String baseCurrency, @PathVariable String quoteCurrency) {
        return marketInsightsService.getMarketInsights(baseCurrency, quoteCurrency);
    }

    @GetMapping
    public List<MarketInsights> getAllMarketInsights() {
        return marketInsightsService.getAllMarketInsights();
    }

   

    @PostMapping
    public MarketInsights createMarketInsights(@RequestBody MarketInsights marketInsights) {
        return marketInsightsService.createMarketInsights(marketInsights);
    }

    @PutMapping("/{id}")
    public MarketInsights updateMarketInsights(@PathVariable Integer id, @RequestBody MarketInsights marketInsights) {
        return marketInsightsService.updateMarketInsights(id, marketInsights);
    }

    @DeleteMapping("/{id}")
    public void deleteMarketInsights(@PathVariable Integer id) {
        marketInsightsService.deleteMarketInsights(id);
    }
}
