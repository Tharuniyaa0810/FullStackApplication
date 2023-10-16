package com.astrasquad.tharuniyaa.dto.request;

import java.util.Map;

import com.astrasquad.tharuniyaa.model.enumerate.CurrencyType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletRequest {
	private Map<CurrencyType, Double> currencyBalances;
    private CurrencyType currencyType;
    private double balance;
    
    // Other relevant fields or methods

}
