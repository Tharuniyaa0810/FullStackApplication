package com.astrasquad.tharuniyaa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    private String type;
    private double amount;
    private String paymentMethod;
    private String purpose;
    private String notes;
    private String currencyType;
}
