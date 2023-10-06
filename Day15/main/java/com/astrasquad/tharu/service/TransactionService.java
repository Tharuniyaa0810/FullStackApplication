package com.astrasquad.tharu.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.astrasquad.tharu.dto.TransactionRequestDTO;
import com.astrasquad.tharu.dto.TransactionResponseDTO;
import com.astrasquad.tharu.model.Transaction;
import com.astrasquad.tharu.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction createTransaction(TransactionRequestDTO requestDTO) {
        Transaction transaction = mapRequestDTOToTransaction(requestDTO);
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, TransactionRequestDTO requestDTO) {
        if (transactionRepository.existsById(id)) {
            Transaction transaction = mapRequestDTOToTransaction(requestDTO);
            transaction.setId(id); // Ensure the ID is set for the update
            return transactionRepository.save(transaction);
        } else {
            throw new NoSuchElementException("Transaction not found");
        }
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    private Transaction mapRequestDTOToTransaction(TransactionRequestDTO requestDTO) {
        Transaction transaction = new Transaction();
        transaction.setUsername(requestDTO.getUsername());
        transaction.setFromCurrency(requestDTO.getFromCurrency());
        transaction.setToCurrency(requestDTO.getToCurrency());
        transaction.setConvertedAmount(requestDTO.getAmount());
        // Map other fields as needed
        return transaction;
    }
    private TransactionResponseDTO mapTransactionToResponseDTO(Transaction transaction) {
        TransactionResponseDTO responseDTO = new TransactionResponseDTO();
        responseDTO.setId(transaction.getId());
        responseDTO.setUsername(transaction.getUsername());
        responseDTO.setFromCurrency(transaction.getFromCurrency());
        responseDTO.setToCurrency(transaction.getToCurrency());
        responseDTO.setConvertedAmount(transaction.getConvertedAmount());
        responseDTO.setNumberOfTransactions(transaction.getNumberOfTransactions());
        // Map other fields as needed
        return responseDTO;
    }
   
}

