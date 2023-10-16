package com.astrasquad.tharuniyaa.service.impl;

import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.astrasquad.tharuniyaa.dto.request.WalletRequest;
import com.astrasquad.tharuniyaa.dto.response.WalletResponse;
import com.astrasquad.tharuniyaa.model.User;
import com.astrasquad.tharuniyaa.model.Wallet;
import com.astrasquad.tharuniyaa.model.enumerate.CurrencyType;
import com.astrasquad.tharuniyaa.repository.UserRepository;
import com.astrasquad.tharuniyaa.repository.WalletRepository;
import com.astrasquad.tharuniyaa.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {
	private static final Logger logger = LoggerFactory.getLogger(WalletServiceImpl.class);

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public WalletResponse createWallet(WalletRequest walletRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserId = authentication.getName(); // Assuming the user's ID is stored as the username

        // Find the associated user by user ID
        Optional<User> userOptional = userRepository.findByUsername(loggedInUserId);
        if (!userOptional.isPresent()) {
            // Throw a 404 Not Found response exception when the user is not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + loggedInUserId);
        }

        User user = userOptional.get();
        Optional<Wallet> existingWallet = walletRepository.findById(user.getUid());

        Wallet wallet;
        if (existingWallet.isPresent()) {
            wallet = existingWallet.get();
            CurrencyType newCurrencyType = walletRequest.getCurrencyType();
            if (wallet.getCurrencyBalances().containsKey(newCurrencyType)) {
                throw new RuntimeException("User already has a wallet with the same currency type");
            }
            wallet.getCurrencyBalances().put(newCurrencyType, walletRequest.getBalance());
        } else {
            wallet = new Wallet();
            wallet.setUser(user);
            wallet.getCurrencyBalances().put(walletRequest.getCurrencyType(), walletRequest.getBalance());
        }

        Wallet savedWallet = walletRepository.save(wallet);
        return convertToWalletResponse(savedWallet);
    }


 // Assume you have a method in your service for updating a user's wallet
    @Override
    public WalletResponse updateUserWallet(Long userId, WalletRequest walletRequest) {
        Optional<Wallet> walletOptional = walletRepository.findById(userId);
        if (walletOptional.isPresent()) {
            Wallet wallet = walletOptional.get();
            Map<CurrencyType, Double> updatedCurrencyBalances = walletRequest.getCurrencyBalances();
            wallet.setCurrencyBalances(updatedCurrencyBalances);
            walletRepository.save(wallet);
            return new WalletResponse("Wallet updated successfully");
        } else {
            throw new RuntimeException("Wallet not found for the user.");
        }
    }


    @Override
    public WalletResponse getWalletByUserId(Long userId) {
        Wallet wallet = walletRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        return convertToWalletResponse(wallet);
    }
    @Override
    public void deleteWalletByUserId(Long userId) {
        Optional<Wallet> walletOptional = walletRepository.findById(userId);
        if (walletOptional.isPresent()) {
            walletRepository.delete(walletOptional.get());
        } else {
            throw new RuntimeException("Wallet not found");
        }
    }


    // Other method implementations

    private WalletResponse convertToWalletResponse(Wallet wallet) {
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setId(wallet.getId());
        walletResponse.setUserId(wallet.getUser().getUid());
        walletResponse.setCurrencyBalances(wallet.getCurrencyBalances());
        return walletResponse;
    }
    
}
