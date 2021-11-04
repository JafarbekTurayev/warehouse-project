package com.example.warehouseapp.controller;

import com.example.warehouseapp.entity.Category;
import com.example.warehouseapp.entity.Warehouse;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.service.CategoryService;
import com.example.warehouseapp.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PreAuthorize(value = "hasAuthority('ADD_CATEGORY')")
    @PostMapping
    public HttpEntity<?>addCategory(@RequestBody Category category){
        ApiResponse response = categoryService.save(category);
        return ResponseEntity.status(response.isSuccess() ? 201:409).body(response);
    }

    @PreAuthorize(value = "hasAuthority('READ_CATEGORY')")
    @GetMapping
    public HttpEntity<?> allCategory(){
         List<Category> all = categoryService.getAll();
        return ResponseEntity.ok(all);
    }

}
