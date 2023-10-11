package com.astrasquad.tharuniyaa.service;

import java.util.List;
import java.util.Optional;

import com.astrasquad.tharuniyaa.model.Wallet;

public interface WalletService {

	Wallet createWallet(Wallet wallet);

	Optional<Wallet> getWalletById(Long id);

	List<Wallet> getAllWallets();

	Wallet updateWallet(Wallet wallet);

	void deleteWallet(Long id);

}
