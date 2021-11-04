package com.example.warehouseapp.controller;

import com.example.warehouseapp.entity.Supplier;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.SupplierDTO;
import com.example.warehouseapp.repository.SupplierRepository;
import com.example.warehouseapp.service.SupplierServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/login/suplier")
@PreAuthorize(value="hasAuthority(' READ_PRODUCT')")
public class SuplierController {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    SupplierServise supplierServise;

    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody Supplier supplier){
        ApiResponse apiResponse = supplierServise.add(supplier);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok(supplierRepository.findAll());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse response =supplierServise.getOne(id);
        return ResponseEntity.status(response.isSuccess() ? 200 : 404).body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody Supplier supplier) {
        ApiResponse response = supplierServise.edit(id,supplier);
        return ResponseEntity.status(response.isSuccess() ? 200 : 404).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        if (!supplierRepository.existsById(id)) return ResponseEntity.ok("Not found!");

        supplierRepository.deleteById(id);
        return ResponseEntity.ok("OK");
    }
    @GetMapping("/search")
    public HttpEntity<?> search(@RequestParam String name) {
        List<Supplier> list = supplierRepository.findByNameStartsWithIgnoreCase(name);
        return ResponseEntity.ok(list);
    }


}
