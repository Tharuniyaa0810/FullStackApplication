package com.astrasquad.tharuniyaa.service.impl;

import com.astrasquad.tharuniyaa.dto.request.TransactionRequest;
import com.astrasquad.tharuniyaa.dto.response.TransactionResponse;
import com.astrasquad.tharuniyaa.model.Transaction;
import com.astrasquad.tharuniyaa.repository.TransactionRepository;
import com.astrasquad.tharuniyaa.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        Transaction transaction = Transaction.builder()
                .type(transactionRequest.getType())
                .amount(transactionRequest.getAmount())
                .paymentMethod(transactionRequest.getPaymentMethod())
                .purpose(transactionRequest.getPurpose())
                .notes(transactionRequest.getNotes())
                .currencyType(transactionRequest.getCurrencyType())
                .transactionDate(new Date()) // Set the current date
                .build();
        Transaction savedTransaction = transactionRepository.save(transaction);
        return mapTransactionToTransactionResponse(savedTransaction);
    }

    @Override
    public TransactionResponse getTransactionById(Long id) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (transactionOptional.isPresent()) {
            Transaction transaction = transactionOptional.get();
            return mapTransactionToTransactionResponse(transaction);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    @Override
    public List<TransactionResponse> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(this::mapTransactionToTransactionResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionResponse updateTransaction(Long id, TransactionRequest transactionRequest) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (transactionOptional.isPresent()) {
            Transaction existingTransaction = transactionOptional.get();
            existingTransaction.setType(transactionRequest.getType());
            existingTransaction.setAmount(transactionRequest.getAmount());
            existingTransaction.setPaymentMethod(transactionRequest.getPaymentMethod());
            existingTransaction.setPurpose(transactionRequest.getPurpose());
            existingTransaction.setNotes(transactionRequest.getNotes());
            existingTransaction.setCurrencyType(transactionRequest.getCurrencyType());
            Transaction updatedTransaction = transactionRepository.save(existingTransaction);
            return mapTransactionToTransactionResponse(updatedTransaction);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    // Utility method to map Transaction to TransactionResponse
    private TransactionResponse mapTransactionToTransactionResponse(Transaction transaction) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return TransactionResponse.builder()
                .tid(transaction.getTid())
                .type(transaction.getType())
                .amount(transaction.getAmount())
                .paymentMethod(transaction.getPaymentMethod())
                .purpose(transaction.getPurpose())
                .notes(transaction.getNotes())
                .currencyType(transaction.getCurrencyType())
                .transactionDate(dateFormat.format(transaction.getTransactionDate()))
                .build();
    }
}


