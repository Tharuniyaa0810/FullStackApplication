package com.astrasquad.tharuniyaa.dto.response;


import java.util.Date;

import lombok.Data;

@Data
public class ConversionResponse {
    private Long cid;
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;
    private boolean transactionStatus;
    private Date transactionDate;
    private String username;
    // Other fields, getters, and setters as needed
}
