package com.astrasquad.tharuniyaa.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletRequest {
    private String currencyType;
    private double balance;
    // Other relevant fields or methods
}

