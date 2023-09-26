package com.example.warehouseapp.controller;

import com.example.warehouseapp.entity.Measurement;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/measurement")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    @PreAuthorize(value = "hasAuthority('ADD_MEASUREMENT')")
    @PostMapping
    public HttpEntity<ApiResponse> add(@RequestBody Measurement measurement) {

        ApiResponse apiResponse = measurementService.addMeauserement(measurement);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }


    @PreAuthorize(value = "hasAuthority('READ_MEASUREMENT')")
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        Measurement one = measurementService.getOne(id);
        return ResponseEntity.ok(one);
    }

    @PreAuthorize(value = "hasAuthority('READ_MEASUREMENT')")
    @GetMapping
    public HttpEntity<?> getAll() {
        List<Measurement> all = measurementService.getAll();
        return ResponseEntity.ok(all);
    }

    @PreAuthorize(value = "hasAuthority('EDIT_MEASUREMENT')")
    @PutMapping("/{id}")
    public HttpEntity<ApiResponse> edit(@RequestBody Measurement measurement, @PathVariable Integer id) {
        ApiResponse apiResponse = measurementService.edit(measurement, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PreAuthorize(value = "hasAuthority('DELETE_MEASUREMENT')")
    @DeleteMapping("/{id}")
    public HttpEntity<ApiResponse> delete(@PathVariable Integer id) {

        ApiResponse apiResponse = measurementService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
