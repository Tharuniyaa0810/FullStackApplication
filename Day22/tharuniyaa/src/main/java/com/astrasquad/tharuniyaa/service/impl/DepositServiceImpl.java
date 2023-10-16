package com.astrasquad.tharuniyaa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrasquad.tharuniyaa.dto.request.DepositRequest;
import com.astrasquad.tharuniyaa.dto.response.DepositResponse;
import com.astrasquad.tharuniyaa.model.Deposit;
import com.astrasquad.tharuniyaa.model.User;
import com.astrasquad.tharuniyaa.repository.DepositRepository;
import com.astrasquad.tharuniyaa.service.DepositService;
import com.astrasquad.tharuniyaa.service.UserService;

@Service
public class DepositServiceImpl implements DepositService {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private UserService userService;

    @Override
    public DepositResponse createDeposit(DepositRequest depositRequest) {
        User user = userService.getUserById(depositRequest.getUserId());
        
        Deposit deposit = Deposit.builder()
                .amount(depositRequest.getAmount())
                .currencyType(depositRequest.getCurrencyType())
                .notes(depositRequest.getNotes())
                .transactionDate(depositRequest.getTransactionDate())
                .user(user)
                .build();
        deposit = depositRepository.save(deposit);
        return convertToDepositResponse(deposit);
    }


    private DepositResponse convertToDepositResponse(Deposit deposit) {
        DepositResponse depositResponse = new DepositResponse();
        depositResponse.setDid(deposit.getDid());
        depositResponse.setAmount(deposit.getAmount());
        depositResponse.setCurrencyType(deposit.getCurrencyType());
        depositResponse.setNotes(deposit.getNotes());
        depositResponse.setTransactionDate(deposit.getTransactionDate());
        depositResponse.setUsername(deposit.getUser().getUsername());
        return depositResponse;
    }
    @Override
    public List<DepositResponse> getAllDeposits() {
        List<Deposit> deposits = depositRepository.findAll();
        return deposits.stream()
                .map(this::convertToDepositResponse)
                .collect(Collectors.toList());
    }
}
