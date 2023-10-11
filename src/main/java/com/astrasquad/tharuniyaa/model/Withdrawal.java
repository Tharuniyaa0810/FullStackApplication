package com.astrasquad.tharuniyaa.model;


import java.util.Date;

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
@Entity
@Table(name = "_withdrawal")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Withdrawal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long wid;
 private double amount;
 private String currencyType;
 private String notes;
 private Date transactionDate;
 @ManyToOne
 @JoinColumn(name = "user_id")
 private User user;
 @Temporal(TemporalType.TIMESTAMP)
 @Column(name = "transaction_date")

 // Setter method for the 'user' field
 public void setUser(User user) {
     this.user = user;
 }
}

