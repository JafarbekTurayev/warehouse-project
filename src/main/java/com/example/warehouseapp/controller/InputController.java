package com.example.warehouseapp.controller;

import com.example.warehouseapp.entity.Input;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.responce.InputDTO;
import com.example.warehouseapp.repository.InputRepository;
import com.example.warehouseapp.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("api/input")
public class InputController {
    @Autowired
    InputRepository inputRepository;

    @Autowired
    InputService inputService;

    //kirim
    @PostMapping
    public HttpEntity<?> add(@RequestBody InputDTO inputDTO) throws ParseException {

        ApiResponse response = inputService.add(inputDTO);
        return ResponseEntity.ok(response);
    }

}
