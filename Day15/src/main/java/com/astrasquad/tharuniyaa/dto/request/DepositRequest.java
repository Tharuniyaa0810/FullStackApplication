package com.astrasquad.tharuniyaa.dto.request;

import java.util.Date;

import lombok.Data;

@Data
public class DepositRequest {
    private double amount;
    private String currencyType;
    private String notes;
    private Date transactionDate;
    private Long userId; // User ID associated with the deposit
}
