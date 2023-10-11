package com.astrasquad.tharuniyaa.controller;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrasquad.tharuniyaa.dto.request.WalletRequest;
import com.astrasquad.tharuniyaa.dto.response.WalletResponse;
import com.astrasquad.tharuniyaa.model.Wallet;
import com.astrasquad.tharuniyaa.model.enumerate.CurrencyType;
import com.astrasquad.tharuniyaa.service.WalletService;



@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/create")
    public ResponseEntity<WalletResponse> createWallet(@RequestBody WalletRequest walletRequestDTO) {
        Wallet wallet = mapWalletRequestDTOToWallet(walletRequestDTO);
        Wallet createdWallet = walletService.createWallet(wallet);
        WalletResponse responseDTO = mapWalletToWalletResponseDTO(createdWallet);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletResponse> getWalletById(@PathVariable Long id) {
        Optional<Wallet> walletOptional = walletService.getWalletById(id);
        if (walletOptional.isPresent()) {
            WalletResponse responseDTO = mapWalletToWalletResponseDTO(walletOptional.get());
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<WalletResponse>> getAllWallets() {
        List<Wallet> wallets = walletService.getAllWallets();
        List<WalletResponse> responseDTOs = wallets.stream()
                .map(this::mapWalletToWalletResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/update")
    public ResponseEntity<WalletResponse> updateWallet(@RequestBody WalletRequest walletRequestDTO) {
        Wallet wallet = mapWalletRequestDTOToWallet(walletRequestDTO);
        Wallet updatedWallet = walletService.updateWallet(wallet);
        WalletResponse responseDTO = mapWalletToWalletResponseDTO(updatedWallet);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);
        return ResponseEntity.noContent().build();
    }

    // Utility methods for mapping DTOs to entities and vice versa
    private Wallet mapWalletRequestDTOToWallet(WalletRequest walletRequestDTO) {
        Wallet wallet = new Wallet();
        // Use the CurrencyType enum to set the balance
        wallet.getCurrencyBalances().put(CurrencyType.valueOf(walletRequestDTO.getCurrencyType()), walletRequestDTO.getBalance());
        // Map other relevant fields
        return wallet;
    }

    private WalletResponse mapWalletToWalletResponseDTO(Wallet wallet) {
        WalletResponse responseDTO = new WalletResponse();
        responseDTO.setId(wallet.getId());
        
        // To get the balance for a specific currency, you can do something like this:
        double balanceForUSD = wallet.getCurrencyBalances().get(CurrencyType.USD);
        
        // Set the currency type and balance in the response DTO
        responseDTO.setCurrencyType(CurrencyType.USD.name()); // Convert the enum to its name
        responseDTO.setBalance(balanceForUSD);
        
        // Map other relevant fields
        return responseDTO;
    }
   


}


