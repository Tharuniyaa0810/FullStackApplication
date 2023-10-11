package com.astrasquad.tharuniyaa.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.astrasquad.tharuniyaa.dto.request.DepositRequest;
import com.astrasquad.tharuniyaa.dto.response.DepositResponse;
import com.astrasquad.tharuniyaa.model.Deposit;
import com.astrasquad.tharuniyaa.model.User;
import com.astrasquad.tharuniyaa.repository.DepositRepository;
import com.astrasquad.tharuniyaa.repository.UserRepository;
import com.astrasquad.tharuniyaa.service.DepositService;

@Service
public class DepositServiceImpl implements DepositService {
    private final DepositRepository depositRepository;
    private final UserRepository userRepository;

    @Autowired
    public DepositServiceImpl(DepositRepository depositRepository, UserRepository userRepository) {
        this.depositRepository = depositRepository;
        this.userRepository = userRepository;
    }
    @Override
    public DepositResponse createDeposit(DepositRequest depositRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserId = authentication.getName(); // Assuming the user's ID is stored as the username

        // Find the associated user by user ID
        Optional<User> userOptional = userRepository.findByUsername(loggedInUserId);
        if (!userOptional.isPresent()) {
            // Throw a 404 Not Found response exception when the user is not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + loggedInUserId);
        }

        User user = userOptional.get();

        // Create a new deposit
        Deposit deposit = new Deposit();
        deposit.setAmount(depositRequest.getAmount());
        deposit.setCurrencyType(depositRequest.getCurrencyType());
        deposit.setNotes(depositRequest.getNotes());
        deposit.setTransactionDate(new Date());
        deposit.setUser(user);

        Deposit savedDeposit = depositRepository.save(deposit);

        return mapDepositToResponse(savedDeposit);
    }
    @Override
    public List<DepositResponse> getAllDeposits() {
        List<Deposit> deposits = depositRepository.findAll();
        return deposits.stream()
                .map(this::mapDepositToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DepositResponse getDepositById(Long depositId) {
        try {
            Deposit deposit = depositRepository.findById(depositId).orElseThrow(() -> new EmptyResultDataAccessException(1));
            return mapDepositToResponse(deposit);
        } catch (EmptyResultDataAccessException ex) {
            // Handle the exception here or let it propagate to the controller
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Deposit not found with ID: " + depositId);
        }
    }


@Override
public DepositResponse updateDeposit(Long depositId, DepositRequest depositRequest) {
    // Find the deposit by ID
    Optional<Deposit> depositOptional = depositRepository.findById(depositId);
    if (!depositOptional.isPresent()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Deposit not found with ID: " + depositId);
    }

    Deposit existingDeposit = depositOptional.get();

    // Update the deposit with new information
    existingDeposit.setAmount(depositRequest.getAmount());
    existingDeposit.setCurrencyType(depositRequest.getCurrencyType());
    existingDeposit.setNotes(depositRequest.getNotes());
    existingDeposit.setTransactionDate(depositRequest.getTransactionDate());

    Deposit updatedDeposit = depositRepository.save(existingDeposit);

    return mapDepositToResponse(updatedDeposit);
}

    @Override
    public void deleteDeposit(Long depositId) {
        depositRepository.deleteById(depositId);
    }

    private DepositResponse mapDepositToResponse(Deposit deposit) {
        DepositResponse response = new DepositResponse();
        response.setDid(deposit.getDid());
        response.setAmount(deposit.getAmount());
        response.setCurrencyType(deposit.getCurrencyType());
        response.setNotes(deposit.getNotes());
        response.setTransactionDate(deposit.getTransactionDate());
        response.setUsername(deposit.getUser().getUsername()); // Set the username
        return response;
    }
}

