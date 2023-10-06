package com.astrasquad.tharu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrasquad.tharu.model.Conversion;

import com.astrasquad.tharu.repository.ConversionRepository;


@Service
public class ConversionService {

    @Autowired
    private ConversionRepository conRepo;

    public Conversion createConversion( Conversion convert) {
        // Implement logic to create and save an event
        return conRepo.save(convert);
    }

    public Conversion getConversionById(Long conversionId) {
        // Implement logic to retrieve an event by ID
        Optional<Conversion> convertOptional = conRepo.findById(conversionId);
        return convertOptional.orElse(null);
    }

    public List<Conversion> getAllConversions() {
        // Implement logic to retrieve all events
        return conRepo.findAll();
    }

    public Conversion updateConversion(Conversion convert) {
        // Implement logic to update and save an event
        return conRepo.save(convert);
    }

    public void deleteConversion(Long conversionId) {
        // Implement logic to delete an event by ID
        conRepo.deleteById(conversionId);
    }
}
