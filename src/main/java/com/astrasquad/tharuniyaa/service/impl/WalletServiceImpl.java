package com.astrasquad.tharuniyaa.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrasquad.tharuniyaa.model.Wallet;
import com.astrasquad.tharuniyaa.repository.WalletRepository;
import com.astrasquad.tharuniyaa.service.WalletService;


@Service
public class WalletServiceImpl implements WalletService  {
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

