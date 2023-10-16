package com.astrasquad.tharuniyaa.service;

import com.astrasquad.tharuniyaa.dto.request.ConversionRequest;
import com.astrasquad.tharuniyaa.dto.response.ConversionResponse;

import java.util.List;

public interface ConversionService {
    ConversionResponse createConversion(ConversionRequest conversionRequest);

    ConversionResponse getConversionById(Long cid);

    List<ConversionResponse> getAllConversions();

    ConversionResponse updateConversion(Long cid, ConversionRequest conversionRequest);

    void deleteConversion(Long cid);
}
