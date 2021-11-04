package com.example.warehouseapp.controller;

import com.example.warehouseapp.entity.Output;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.repository.OutputRepository;
import com.example.warehouseapp.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/output")
public class outputController {
    @Autowired
    OutputService outputService;

    @PreAuthorize(value = "hasAuthority('ADD_OUTPUT')")
    @PostMapping("/add")
    public HttpEntity<?> addoutput(@RequestBody Output output){
        ApiResponse response = outputService.save(output);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }
//    @GetMapping("/get")
//    public List<Output> getAll(){
//        return outputService.all();
//    }
//    @DeleteMapping("/{id}")
//    public String remove(@PathVariable Integer id){
//        return outputService.remove(id);
//    }
}
