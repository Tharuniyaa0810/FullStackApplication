package com.astrasquad.tharuniyaa.dto.response;

import com.astrasquad.tharuniyaa.model.enumerate.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletResponse {
  

	private Long id;
    private Long userId;
   
    private Map<CurrencyType, Double> currencyBalances;
    private String message;

    public WalletResponse(String message) {
        this.message = message;
    }
    // Other properties, getters, and setters
}
