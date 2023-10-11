package com.astrasquad.tharuniyaa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletResponse {
    private Long id;
    private String currencyType;
    private double balance;
    // Other relevant fields or methods
}
