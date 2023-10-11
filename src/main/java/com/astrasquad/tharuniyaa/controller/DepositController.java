package com.astrasquad.tharuniyaa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrasquad.tharuniyaa.dto.request.DepositRequest;
import com.astrasquad.tharuniyaa.dto.response.DepositResponse;
import com.astrasquad.tharuniyaa.service.DepositService;

@RestController
@RequestMapping("/api/deposits")
public class DepositController {
    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/create")
    public DepositResponse createDeposit(@RequestBody DepositRequest depositRequest) {
        return depositService.createDeposit(depositRequest);
    }

    @GetMapping
    public List<DepositResponse> getAllDeposits() {
        return depositService.getAllDeposits();
    }

    @GetMapping("/{id}")
    public DepositResponse getDepositById(@PathVariable Long id) {
        return depositService.getDepositById(id);
    }

    @PutMapping("/{id}")
    public DepositResponse updateDeposit(@PathVariable Long id, @RequestBody DepositRequest depositRequest) {
        return depositService.updateDeposit(id, depositRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteDeposit(@PathVariable Long id) {
        depositService.deleteDeposit(id);
    }
}

