package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.*;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.responce.OutputDto;
import com.example.warehouseapp.payload.responce.OutputProductDto;
import com.example.warehouseapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputProductRepository outputProductRepository;
    public ApiResponse addOutput(OutputDto outputDto) {
        Output output  = new Output();
        output.setDate(new Date());
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouseId());
        output.setWarehouse(optionalWarehouse.get());
        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        output.setCurrency(optionalCurrency.get());
        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClientId());
        output.setClient(optionalClient.get());
        output.setFactureNumber(outputDto.getFactureNumber());
        outputRepository.save(output);

        List<OutputProductDto> outputProductDtoList = outputDto.getOutputProductDtoList();
        
        List<OutputProduct>outputProductList = new ArrayList<>();

        for (OutputProductDto outputProductDtofor : outputProductDtoList) {
            OutputProduct outputProduct = new OutputProduct();
            Optional<Product> optionalProduct = productRepository.findById(outputProductDtofor.getProductId());
            outputProduct.setProduct(optionalProduct.get());
            outputProduct.setPrice(outputProductDtofor.getPrice());
            outputProduct.setAmount(outputProductDtofor.getAmount());
            outputProduct.setOutput(output);
            outputProductList.add(outputProduct);
        }
        output.setOutputProductList(outputProductList);
outputRepository.save(output);
return  new ApiResponse("Saved",true,output);
    }

    public ApiResponse getById(Integer id) {
        Optional<Output> optionalOutputId = outputRepository.findById(id);
        return  new ApiResponse("Id = ",true,optionalOutputId.get());
    }

    public ApiResponse aditById(Integer id, OutputDto outputDto) {
        Optional<Output> optionalOutputId = outputRepository.findById(id);
        if (optionalOutputId.isPresent()) {
            return new ApiResponse("Not Found 404",false);
        }
        Output editIdOutput = optionalOutputId.get();
        editIdOutput.setFactureNumber(outputDto.getFactureNumber());
        Output save = outputRepository.save(editIdOutput);
        return new ApiResponse("Edited",true,save);

    }
}
