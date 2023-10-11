package com.astrasquad.tharuniyaa.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.astrasquad.tharuniyaa.dto.request.ConversionRequest;
import com.astrasquad.tharuniyaa.dto.response.ConversionResponse;
import com.astrasquad.tharuniyaa.model.Conversion;
import com.astrasquad.tharuniyaa.model.User;
import com.astrasquad.tharuniyaa.repository.ConversionRepository;
import com.astrasquad.tharuniyaa.repository.UserRepository;
import com.astrasquad.tharuniyaa.service.ConversionService;

@Service
public class ConversionServiceImpl implements ConversionService {
    private final ConversionRepository conversionRepository;
    private final UserRepository userRepository;

    @Autowired
    public ConversionServiceImpl(ConversionRepository conversionRepository, UserRepository userRepository) {
        this.conversionRepository = conversionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ConversionResponse createConversion(ConversionRequest conversionRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserId = authentication.getName(); // Assuming the user's ID is stored as the username

        // Find the associated user by user ID
        Optional<User> userOptional = userRepository.findByUsername(loggedInUserId);
        if (!userOptional.isPresent()) {
            // Throw a 404 Not Found response exception when the user is not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with ID: " + loggedInUserId);
        }

        User user = userOptional.get();

        // Create a new conversion
        Conversion conversion = new Conversion();
        conversion.setFromCurrency(conversionRequest.getFromCurrency());
        conversion.setToCurrency(conversionRequest.getToCurrency());
        conversion.setAmount(conversionRequest.getAmount());
        conversion.setConvertedAmount(calculateConvertedAmount(conversionRequest.getFromCurrency(), conversionRequest.getToCurrency(), conversionRequest.getAmount()));
        conversion.setTransactionStatus(true);
        conversion.setTransactionDate(new Date());
        conversion.setUser(user);

        Conversion savedConversion = conversionRepository.save(conversion);

        return mapConversionToResponse(savedConversion);
    }

    @Override
    public List<ConversionResponse> getAllConversions() {
        List<Conversion> conversions = conversionRepository.findAll();
        return conversions.stream()
                .map(this::mapConversionToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ConversionResponse getConversionById(Long conversionId) {
        try {
            Conversion conversion = conversionRepository.findById(conversionId).orElseThrow(() -> new EmptyResultDataAccessException(1));
            return mapConversionToResponse(conversion);
        } catch (EmptyResultDataAccessException ex) {
            // Handle the exception here or let it propagate to the controller
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conversion not found with ID: " + conversionId);
        }
    }

    @Override
    public ConversionResponse updateConversion(Long conversionId, ConversionRequest conversionRequest) {
        // Find the conversion by ID
        Optional<Conversion> conversionOptional = conversionRepository.findById(conversionId);
        if (!conversionOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conversion not found with ID: " + conversionId);
        }

        Conversion existingConversion = conversionOptional.get();

        // Update the conversion with new information
        existingConversion.setFromCurrency(conversionRequest.getFromCurrency());
        existingConversion.setToCurrency(conversionRequest.getToCurrency());
        existingConversion.setAmount(conversionRequest.getAmount());
        existingConversion.setConvertedAmount(calculateConvertedAmount(conversionRequest.getFromCurrency(), conversionRequest.getToCurrency(), conversionRequest.getAmount()));
        existingConversion.setTransactionStatus(true);
        existingConversion.setTransactionDate(new Date());

        Conversion updatedConversion = conversionRepository.save(existingConversion);

        return mapConversionToResponse(updatedConversion);
    }

    @Override
    public void deleteConversion(Long conversionId) {
        conversionRepository.deleteById(conversionId);
    }

    private ConversionResponse mapConversionToResponse(Conversion conversion) {
        ConversionResponse response = new ConversionResponse();
        response.setCid(conversion.getCid());
        response.setFromCurrency(conversion.getFromCurrency());
        response.setToCurrency(conversion.getToCurrency());
        response.setAmount(conversion.getAmount());
        response.setConvertedAmount(conversion.getConvertedAmount());
        response.setTransactionStatus(conversion.isTransactionStatus());
        response.setTransactionDate(conversion.getTransactionDate());
        response.setUsername(conversion.getUser().getUsername()); // Set the username
        return response;
    }

    private double calculateConvertedAmount(String fromCurrency, String toCurrency, double amount) {
        // Implement your currency conversion logic here
        // This is a placeholder method, you should implement the actual conversion logic based on exchange rates or other data sources.
        return amount * 2.0; // Replace with your conversion logic
    }
}
