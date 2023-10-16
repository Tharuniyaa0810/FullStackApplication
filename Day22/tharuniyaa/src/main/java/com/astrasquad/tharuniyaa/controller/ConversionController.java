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

import com.astrasquad.tharuniyaa.constant.Api;
import com.astrasquad.tharuniyaa.dto.request.ConversionRequest;
import com.astrasquad.tharuniyaa.dto.response.ConversionResponse;
import com.astrasquad.tharuniyaa.service.ConversionService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;

  

    @PostMapping("/convert/post")
    public ConversionResponse createConversion(@RequestBody ConversionRequest conversionRequest) {
        return conversionService.createConversion(conversionRequest);
    }

    @GetMapping("/convert/{cid}")
    public ConversionResponse getConversionById(@PathVariable Long cid) {
        return conversionService.getConversionById(cid);
    }

    @GetMapping("/convert/get")
    public List<ConversionResponse> getAllConversions() {
        return conversionService.getAllConversions();
    }

    @PutMapping("/convert/get/{cid}")
    public ConversionResponse updateConversion(@PathVariable Long cid, @RequestBody ConversionRequest conversionRequest) {
        return conversionService.updateConversion(cid, conversionRequest);
    }

    @DeleteMapping("/convert/del/{cid}")
    public void deleteConversion(@PathVariable Long cid) {
        conversionService.deleteConversion(cid);
    }
}
