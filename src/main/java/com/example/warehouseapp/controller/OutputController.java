package com.example.warehouseapp.controller;

import com.example.warehouseapp.entity.Output;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.responce.OutputDto;
import com.example.warehouseapp.repository.OutputRepository;
import com.example.warehouseapp.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;
    @Autowired
    OutputRepository outputRepository;

    @PostMapping
    public HttpEntity<?> addOutput(@RequestBody OutputDto outputDto){
        ApiResponse response = outputService.addOutput(outputDto);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @GetMapping("/all")
    public HttpEntity<?>getAll(){
        List<Output> outputs = outputRepository.findAll();
        return ResponseEntity.ok(outputs);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        ApiResponse responseOne = outputService.getById(id);
        return ResponseEntity.ok(responseOne);
    }
    @PutMapping("/edit")
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody OutputDto outputDto){
        ApiResponse responseEdit = outputService.aditById(id,outputDto);
        return ResponseEntity.ok(responseEdit);
    }
    @DeleteMapping("{id}")
    public HttpEntity<?>removeId(@PathVariable Integer id){
        if (!outputRepository.existsById(id)) {
            return  ResponseEntity.ok("Not Found");
        }
        Optional<Output> optionalOutput = outputRepository.findById(id);
        return ResponseEntity.ok("Deleted");
    }

}
