package com.astrasquad.tharuniyaa.service;

import com.astrasquad.tharuniyaa.dto.request.TransactionRequest;
import com.astrasquad.tharuniyaa.dto.response.TransactionResponse;

import java.util.List;

public interface TransactionService {
    TransactionResponse createTransaction(TransactionRequest transactionRequest);
    TransactionResponse getTransactionById(Long id);
    List<TransactionResponse> getAllTransactions();
    TransactionResponse updateTransaction(Long id, TransactionRequest transactionRequest);
    void deleteTransaction(Long id);
}

