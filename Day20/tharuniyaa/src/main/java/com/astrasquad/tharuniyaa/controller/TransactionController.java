package com.astrasquad.tharuniyaa.controller;

import com.astrasquad.tharuniyaa.dto.request.TransactionRequest;
import com.astrasquad.tharuniyaa.dto.response.TransactionResponse;
import com.astrasquad.tharuniyaa.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionRequest transactionRequest) {
        TransactionResponse response = transactionService.createTransaction(transactionRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable Long id) {
        TransactionResponse response = transactionService.getTransactionById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TransactionResponse>> getAllTransactions() {
        List<TransactionResponse> responseList = transactionService.getAllTransactions();
        return ResponseEntity.ok(responseList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TransactionResponse> updateTransaction(@PathVariable Long id, @RequestBody TransactionRequest transactionRequest) {
        TransactionResponse response = transactionService.updateTransaction(id, transactionRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
