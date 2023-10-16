package com.astrasquad.tharuniyaa.dto.request;

import java.util.Date;

import lombok.Data;

@Data
public class DepositRequest {
    private double amount;
    private String currencyType;
    private String notes;
    private String transactionDate;
    private Long userId; // User ID associated with the deposit
}
