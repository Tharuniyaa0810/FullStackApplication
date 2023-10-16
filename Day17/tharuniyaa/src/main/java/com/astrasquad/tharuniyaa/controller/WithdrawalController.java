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

import com.astrasquad.tharuniyaa.dto.request.WithdrawalRequest;
import com.astrasquad.tharuniyaa.dto.response.WithdrawalResponse;
import com.astrasquad.tharuniyaa.service.WithdrawalService;

@RestController
@RequestMapping("/withdrawals")
public class WithdrawalController {

    private final WithdrawalService withdrawalService;

    @Autowired
    public WithdrawalController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    @PostMapping
    public WithdrawalResponse createWithdrawal(@RequestBody WithdrawalRequest withdrawalRequest) {
        return withdrawalService.createWithdrawal(withdrawalRequest);
    }

    @GetMapping("/{wid}")
    public WithdrawalResponse getWithdrawalById(@PathVariable Long wid) {
        return withdrawalService.getWithdrawalById(wid);
    }

    @GetMapping
    public List<WithdrawalResponse> getAllWithdrawals() {
        return withdrawalService.getAllWithdrawals();
    }

    @PutMapping("/{wid}")
    public WithdrawalResponse updateWithdrawal(@PathVariable Long wid, @RequestBody WithdrawalRequest withdrawalRequest) {
        return withdrawalService.updateWithdrawal(wid, withdrawalRequest);
    }

    @DeleteMapping("/{wid}")
    public void deleteWithdrawal(@PathVariable Long wid) {
        withdrawalService.deleteWithdrawal(wid);
    }
}
