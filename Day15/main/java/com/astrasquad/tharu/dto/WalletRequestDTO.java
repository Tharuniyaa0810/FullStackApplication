package com.astrasquad.tharu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletRequestDTO {
    private String currencyType;
    private double balance;
    // Other relevant fields or methods
}

