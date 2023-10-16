package com.astrasquad.tharuniyaa.service.impl;


import com.astrasquad.tharuniyaa.dto.request.WithdrawalRequest;
import com.astrasquad.tharuniyaa.dto.response.WithdrawalResponse;
import com.astrasquad.tharuniyaa.model.Withdrawal;
import com.astrasquad.tharuniyaa.model.User;
import com.astrasquad.tharuniyaa.repository.WithdrawalRepository;
import com.astrasquad.tharuniyaa.repository.UserRepository;
import com.astrasquad.tharuniyaa.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WithdrawalServiceImpl implements WithdrawalService {

    private final WithdrawalRepository withdrawalRepository;
    private final UserRepository userRepository;

    @Autowired
    public WithdrawalServiceImpl(WithdrawalRepository withdrawalRepository, UserRepository userRepository) {
        this.withdrawalRepository = withdrawalRepository;
        this.userRepository = userRepository;
    }

    @Override
    public WithdrawalResponse createWithdrawal(WithdrawalRequest withdrawalRequest) {
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         String loggedInUserId = authentication.getName(); // Assuming the user's ID is stored as the username

        Optional<User> userOptional = userRepository.findByUsername(loggedInUserId);
        if (!userOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + loggedInUserId);
        }

        User user = userOptional.get();

        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setAmount(withdrawalRequest.getAmount());
        withdrawal.setCurrencyType(withdrawalRequest.getCurrencyType());
        withdrawal.setNotes(withdrawalRequest.getNotes());
        
        withdrawal.setUser(user);

        Withdrawal savedWithdrawal = withdrawalRepository.save(withdrawal);

        return mapWithdrawalToResponse(savedWithdrawal);
    }

    @Override
    public WithdrawalResponse getWithdrawalById(Long wid) {
        try {
            Withdrawal withdrawal = withdrawalRepository.findById(wid).orElseThrow(() -> new EmptyResultDataAccessException(1));
            return mapWithdrawalToResponse(withdrawal);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Withdrawal not found with ID: " + wid);
        }
    }

    @Override
    public List<WithdrawalResponse> getAllWithdrawals() {
        List<Withdrawal> withdrawals = withdrawalRepository.findAll();
        return withdrawals.stream()
                .map(this::mapWithdrawalToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public WithdrawalResponse updateWithdrawal(Long wid, WithdrawalRequest withdrawalRequest) {
        Optional<Withdrawal> withdrawalOptional = withdrawalRepository.findById(wid);
        if (!withdrawalOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Withdrawal not found with ID: " + wid);
        }

        Withdrawal existingWithdrawal = withdrawalOptional.get();

        existingWithdrawal.setAmount(withdrawalRequest.getAmount());
        existingWithdrawal.setCurrencyType(withdrawalRequest.getCurrencyType());
        existingWithdrawal.setNotes(withdrawalRequest.getNotes());

        Withdrawal updatedWithdrawal = withdrawalRepository.save(existingWithdrawal);

        return mapWithdrawalToResponse(updatedWithdrawal);
    }

    @Override
    public void deleteWithdrawal(Long wid) {
        withdrawalRepository.deleteById(wid);
    }

    private WithdrawalResponse mapWithdrawalToResponse(Withdrawal withdrawal) {
        WithdrawalResponse response = new WithdrawalResponse();
        response.setWid(withdrawal.getWid());
        response.setAmount(withdrawal.getAmount());
        response.setCurrencyType(withdrawal.getCurrencyType());
        response.setNotes(withdrawal.getNotes());
        response.setTransactionDate(withdrawal.getTransactionDate());
        response.setUsername(withdrawal.getUser().getUsername());
        return response;
    }
}

