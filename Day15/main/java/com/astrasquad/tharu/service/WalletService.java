package com.astrasquad.tharu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrasquad.tharu.model.Wallet;
import com.astrasquad.tharu.repository.WalletRepository;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Optional<Wallet> getWalletById(Long id) {
        return walletRepository.findById(id);
    }

    public Wallet updateWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);
    }
   
}

