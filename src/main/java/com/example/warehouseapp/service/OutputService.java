package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.Output;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.repository.OutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;

    public ApiResponse save(Output output) {
        if (outputRepository.existsById(output.getId())){
            outputRepository.save(output);
            return new ApiResponse("Saved",true);
        }
        return new ApiResponse("Hato",false);
    }

//    public List<Output> all() {
//        return outputRepository.findAll();
//    }
//
//    public String remove(Integer id) {
//        outputRepository.deleteById(id);
//        return   "Deleted";
//    }
}
