package com.astrasquad.tharu.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "conversion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conversionId;
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;
    private boolean transactionStatus;
   

}
