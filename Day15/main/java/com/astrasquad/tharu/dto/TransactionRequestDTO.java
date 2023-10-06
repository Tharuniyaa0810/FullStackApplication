package com.astrasquad.tharu.dto;


import lombok.Data;

@Data
public class TransactionRequestDTO {
    private String username;
    private String fromCurrency;
    private String toCurrency;
    private Double amount;
    // Other fields and getters/setters as needed
}
