
package com.astrasquad.tharuniyaa.service;

import java.util.Map;

import com.astrasquad.tharuniyaa.dto.request.WalletRequest;
import com.astrasquad.tharuniyaa.dto.response.WalletResponse;
import com.astrasquad.tharuniyaa.model.enumerate.CurrencyType;

public interface WalletService {
    WalletResponse createWallet(WalletRequest walletRequest);
    WalletResponse getWalletByUserId(Long userId);
	void deleteWalletByUserId(Long userId);
	
	
	WalletResponse updateUserWallet(Long userId, WalletRequest walletRequest);
  
}

