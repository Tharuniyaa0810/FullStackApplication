package com.astrasquad.tharuniyaa.model;

import java.util.HashMap;
import java.util.Map;

import com.astrasquad.tharuniyaa.model.enumerate.CurrencyType;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wallet")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id")
   private User user;

   // Map currency types (using the CurrencyType enum) to their balances
   @ElementCollection
   @CollectionTable(name = "wallet_currencies")
   @MapKeyEnumerated(EnumType.STRING) // Indicates the use of an enum for currency types
   @MapKeyColumn(name = "currency_type") // Specifies the column name for the enum key
   @Column(name = "balance")
   private Map<CurrencyType, Double> currencyBalances = new HashMap<>();

   // Other wallet properties, getters, and setters
}
