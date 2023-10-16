package com.astrasquad.tharuniyaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrasquad.tharuniyaa.dto.request.DepositRequest;
import com.astrasquad.tharuniyaa.dto.response.DepositResponse;
import com.astrasquad.tharuniyaa.service.DepositService;

@RestController
@RequestMapping("/deposits")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping
    public ResponseEntity<DepositResponse> createDeposit(@RequestBody DepositRequest depositRequest) {
        DepositResponse depositResponse = depositService.createDeposit(depositRequest);
        return new ResponseEntity<>(depositResponse, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DepositResponse>> getAllDeposits() {
        List<DepositResponse> depositResponses = depositService.getAllDeposits();
        return new ResponseEntity<>(depositResponses, HttpStatus.OK);
    }
}
