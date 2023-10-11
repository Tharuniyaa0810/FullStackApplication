package com.astrasquad.tharuniyaa.dto.response;


import java.util.Date;

import lombok.Data;

@Data
public class DepositResponse {
    private Long did;
    private double amount;
    private String currencyType;
    private String notes;
    private Date transactionDate;
    private String username; // User's username associated with the deposit
}
