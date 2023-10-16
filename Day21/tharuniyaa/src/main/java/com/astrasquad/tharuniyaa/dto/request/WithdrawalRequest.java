package com.astrasquad.tharuniyaa.dto.request;

import lombok.Data;

@Data
public class WithdrawalRequest {
    private double amount;
    private String currencyType;
    private String notes;
    // Other fields, getters, and setters as needed
}
