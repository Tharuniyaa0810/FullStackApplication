package com.astrasquad.tharu.controller;

import java.util.List;
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

import com.astrasquad.tharu.dto.ConversionRequestDTO;
import com.astrasquad.tharu.dto.ConversionResponseDTO;
import com.astrasquad.tharu.model.Conversion;
import com.astrasquad.tharu.repository.ConversionRepository;
import com.astrasquad.tharu.service.ConversionService;

@RestController
@RequestMapping("/convert")
public class ConversionController {

	@Autowired
	private ConversionService conSer;
	@Autowired
	private ConversionRepository conRepo;
	@PostMapping("/post")
	public ResponseEntity<ConversionResponseDTO> createConversion(@RequestBody ConversionRequestDTO conReq){
		Conversion convert=new Conversion();
		convert.setAmount(conReq.getAmount());
		convert.setConvertedAmount(conReq.getConvertedAmount());
		convert.setFromCurrency(conReq.getFromCurrency());
		convert.setToCurrency(conReq.getToCurrency());
		convert.setTransactionStatus(conReq.isTransactionStatus());
		Conversion createdConversion=conSer.createConversion(convert);
		ConversionResponseDTO responseDTO=new ConversionResponseDTO();
		responseDTO.setConversionID(createdConversion.getConversionId());
		responseDTO.setAmount(createdConversion.getAmount());
		responseDTO.setConvertedAmount(createdConversion.getConvertedAmount());
		responseDTO.setFromCurrency(createdConversion.getFromCurrency());
		responseDTO.setToCurrency(createdConversion.getToCurrency());
		return ResponseEntity.ok(responseDTO);
	}
	@GetMapping("/get")
	public ResponseEntity<List<ConversionResponseDTO>> getAllConversion(){
		List<Conversion> converts=conSer.getAllConversions();
		List<ConversionResponseDTO> responseDTOs=converts.stream()
			.map(convert -> {
				ConversionResponseDTO responseDTO=new ConversionResponseDTO();
				responseDTO.setAmount(convert.getAmount());
				responseDTO.setConversionID(convert.getConversionId());
				responseDTO.setConvertedAmount(convert.getConvertedAmount());
				responseDTO.setFromCurrency(convert.getFromCurrency());
				responseDTO.setToCurrency(convert.getToCurrency());
				responseDTO.setTransactionStatus(convert.isTransactionStatus());
				return responseDTO;
			})
			.collect(Collectors.toList());
		return ResponseEntity.ok(responseDTOs);
				
		
	}
	@PutMapping("/put/{conversionId}")
	public ResponseEntity<ConversionResponseDTO> updateConversion(@PathVariable Long conversionId,@RequestBody ConversionRequestDTO conReq){
		Conversion existingConvert=conSer.getConversionById(conversionId);
		
		existingConvert.setAmount(conReq.getAmount());
		existingConvert.setConvertedAmount(conReq.getConvertedAmount());
		existingConvert.setFromCurrency(conReq.getFromCurrency());
		existingConvert.setToCurrency(conReq.getToCurrency());
		existingConvert.setTransactionStatus(conReq.isTransactionStatus());
	    Conversion updatedConvert=conSer.getConversionById(conversionId);
	    
	    ConversionResponseDTO responseDTO=new ConversionResponseDTO();
	    responseDTO.setConversionID(updatedConvert.getConversionId());
	    responseDTO.setAmount(updatedConvert.getAmount());
	    responseDTO.setConvertedAmount(updatedConvert.getConvertedAmount());
	    responseDTO.setFromCurrency(updatedConvert.getFromCurrency());
	    responseDTO.setToCurrency(updatedConvert.getToCurrency());
	    responseDTO.setTransactionStatus(updatedConvert.isTransactionStatus());
	    
	    return ResponseEntity.ok(responseDTO);
	}
	@DeleteMapping("/del/{conversionId}")
	public ResponseEntity<Void> deleteConversion(@PathVariable Long conversionId){
		conSer.deleteConversion(conversionId);
		return ResponseEntity.noContent().build();
		}
}
