package com.astrasquad.tharuniyaa.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "_conversions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double convertedAmount;
    private boolean transactionStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transaction_date")
    private Date transactionDate;  // Use java.util.Date for auto-generation

    @PrePersist
    protected void onCreate() {
        // Automatically set the transactionDate to the current date and time
        this.transactionDate = new Date();
    }
    // Setter method for the 'user' field
    public void setUser(User user) {
        this.user = user;
    }
}
