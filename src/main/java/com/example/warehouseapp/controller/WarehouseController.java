package com.example.warehouseapp.controller;

import com.example.warehouseapp.entity.Warehouse;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.CategoryDTO;
import com.example.warehouseapp.payload.WarehouseDto;
import com.example.warehouseapp.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @PreAuthorize(value = "hasAuthority('ADD_WAREHOUSE')")
    @PostMapping
    public HttpEntity<?> addWarehouse(@RequestBody Warehouse warehouse) {
        ApiResponse response = warehouseService.save(warehouse);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editCategory(@PathVariable Integer id, @RequestBody WarehouseDto warehouseDto){

        ApiResponse edited = warehouseService.edit(id,warehouseDto);

        return ResponseEntity.status(edited!=null?202:409).body(edited);
    }


    //edit
    @PutMapping("{id}")
    public HttpEntity<?> editWarehouse(@PathVariable Integer id, @RequestBody WarehouseDto warehouseDto){
        ApiResponse editedWarehouse = warehouseService.edit(id,warehouseDto);
        return ResponseEntity.status(editedWarehouse!=null?201:409).body(editedWarehouse);
    }
    //one
    @PutMapping("{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id,@RequestBody WarehouseDto warehouseDto){
        ApiResponse getOneWarehouse = warehouseService.getOne(id,warehouseDto);
        return ResponseEntity.status(getOneWarehouse!=null?201:409).body(getOneWarehouse);
    }
    //all
    @GetMapping
    public HttpEntity<?> allWarehouse(){
        ApiResponse all = warehouseService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }
    //delete active false
    @PutMapping("{id}")
    public HttpEntity<?> changingActivity(@PathVariable Integer id,@RequestBody WarehouseDto warehouseDto){
//        ApiResponse changingAcitivity = warehouseService.changingActivity(id);
//        return ResponseEntity.ok()
        return null;
    }
    //Abdumalik
}