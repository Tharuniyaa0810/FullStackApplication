package com.astrasquad.tharu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConversionResponseDTO {
	 private Long conversionID;
	 private String fromCurrency;
	    private String toCurrency;
	    private double amount;
	    private double convertedAmount;
	    private boolean transactionStatus;
}
