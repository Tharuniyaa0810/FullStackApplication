package com.astrasquad.tharu.dto;



import lombok.Data;

@Data
public class TransactionResponseDTO {
    private Long id;
    private String username;
    private String fromCurrency;
    private String toCurrency;
    private Double convertedAmount;
    private Integer numberOfTransactions;
    // Other fields and getters/setters as needed
}

