package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.Input;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.responce.InputputDTO;
import com.example.warehouseapp.repository.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;

    public ApiResponse add(InputputDTO inputputDTO) {
        Input input = new Input();
        input.setFactureNumber(inputputDTO.getFactureName());
        input.setCurrency(inputputDTO.getCurrency());
        input.setDate(new Date());
        return null;
    }
}
