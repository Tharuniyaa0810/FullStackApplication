package com.astrasquad.tharu.controller;

import java.util.List;
import java.util.Map;
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

import com.astrasquad.tharu.dto.WalletRequestDTO;
import com.astrasquad.tharu.dto.WalletResponseDTO;
import com.astrasquad.tharu.model.Wallet;
import com.astrasquad.tharu.model.enumerate.CurrencyType;
import com.astrasquad.tharu.service.WalletService;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping("/create")
    public ResponseEntity<WalletResponseDTO> createWallet(@RequestBody WalletRequestDTO walletRequestDTO) {
        Wallet wallet = mapWalletRequestDTOToWallet(walletRequestDTO);
        Wallet createdWallet = walletService.createWallet(wallet);
        WalletResponseDTO responseDTO = mapWalletToWalletResponseDTO(createdWallet);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WalletResponseDTO> getWalletById(@PathVariable Long id) {
        Optional<Wallet> walletOptional = walletService.getWalletById(id);
        if (walletOptional.isPresent()) {
            WalletResponseDTO responseDTO = mapWalletToWalletResponseDTO(walletOptional.get());
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<WalletResponseDTO>> getAllWallets() {
        List<Wallet> wallets = walletService.getAllWallets();
        List<WalletResponseDTO> responseDTOs = wallets.stream()
                .map(this::mapWalletToWalletResponseDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/update")
    public ResponseEntity<WalletResponseDTO> updateWallet(@RequestBody WalletRequestDTO walletRequestDTO) {
        Wallet wallet = mapWalletRequestDTOToWallet(walletRequestDTO);
        Wallet updatedWallet = walletService.updateWallet(wallet);
        WalletResponseDTO responseDTO = mapWalletToWalletResponseDTO(updatedWallet);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);
        return ResponseEntity.noContent().build();
    }

    // Utility methods for mapping DTOs to entities and vice versa
    private Wallet mapWalletRequestDTOToWallet(WalletRequestDTO walletRequestDTO) {
        Wallet wallet = new Wallet();
        // Use the CurrencyType enum to set the balance
        wallet.getCurrencyBalances().put(CurrencyType.valueOf(walletRequestDTO.getCurrencyType()), walletRequestDTO.getBalance());
        // Map other relevant fields
        return wallet;
    }

    private WalletResponseDTO mapWalletToWalletResponseDTO(Wallet wallet) {
        WalletResponseDTO responseDTO = new WalletResponseDTO();
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

