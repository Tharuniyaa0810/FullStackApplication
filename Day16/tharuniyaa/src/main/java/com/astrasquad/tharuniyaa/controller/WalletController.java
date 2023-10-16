package com.astrasquad.tharuniyaa.controller;

import com.astrasquad.tharuniyaa.dto.request.WalletRequest;
import com.astrasquad.tharuniyaa.dto.response.WalletResponse;
import com.astrasquad.tharuniyaa.model.Wallet;
import com.astrasquad.tharuniyaa.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<WalletResponse> createWallet(@RequestBody WalletRequest walletRequest) {
        WalletResponse createdWallet = walletService.createWallet(walletRequest);
        return new ResponseEntity<>(createdWallet, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<WalletResponse> getWalletByUserId(@PathVariable Long userId) {
        WalletResponse wallet = walletService.getWalletByUserId(userId);
        return new ResponseEntity<>(wallet, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<WalletResponse> updateWallet(@PathVariable Long userId, @RequestBody WalletRequest walletRequest) {
        WalletResponse updatedWallet = walletService.updateUserWallet(userId, walletRequest);
        return new ResponseEntity<>(updatedWallet, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteWallet(@PathVariable Long userId) {
        walletService.deleteWalletByUserId(userId);
        return new ResponseEntity<>("Wallet with user ID " + userId + " has been deleted", HttpStatus.OK);
    }
}
