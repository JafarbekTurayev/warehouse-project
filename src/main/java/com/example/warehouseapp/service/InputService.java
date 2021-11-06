package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.*;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.responce.InputDTO;
import com.example.warehouseapp.payload.responce.InputProductDTO;
import com.example.warehouseapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputProductRepository inputProductRepository;

    public ApiResponse add(InputDTO inputDTO) throws ParseException {
        Input input = new Input();
        input.setFactureNumber(inputDTO.getFactureName());
        input.setDate(new Date());

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDTO.getCurrencyId());
        input.setCurrency(optionalCurrency.get());
        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDTO.getSupplierId());
        input.setSupplier(optionalSupplier.get());
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDTO.getWarehouseId());
        input.setWarehouse(optionalWarehouse.get());


        //furadan tushirdik
        List<InputProductDTO> inputProductDTOS = inputDTO.getInputProductDTOS();

        List<InputProduct> inputProductList = new ArrayList<>();

        for (InputProductDTO inputProductDTO : inputProductDTOS) {
            InputProduct inputProduct = new InputProduct();

            //iphone
            Optional<Product> optionalProduct = productRepository.findById(inputProductDTO.getProductId());
            inputProduct.setProduct(optionalProduct.get());

            inputProduct.setAmount(inputProductDTO.getAmount());
            inputProduct.setPrice(inputProductDTO.getPrice());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormat.parse(inputProductDTO.getExpireDate());
            inputProduct.setExpireDate(date);
            inputProduct.setInput(input);

            inputProductList.add(inputProduct);
        }
        input.setInputProductList(inputProductList);
        inputRepository.save(input);
        return new ApiResponse("Saved!", true, input);
    }
}
