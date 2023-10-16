package com.astrasquad.tharuniyaa.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//... imports
import org.springframework.format.annotation.DateTimeFormat;

//... other imports

@Entity
@Table(name = "_deposit")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deposit {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long did;
 private double amount;
 private String currencyType;
 private String notes;
 private String transactionDate; // Keep the type as String

 @ManyToOne
 @JoinColumn(name = "user_id")
 private User user;

 // Setter method for the 'user' field
 public void setUser(User user) {
     this.user = user;
 }
}
