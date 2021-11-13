package com.example.warehouseapp.controller;

import com.example.warehouseapp.entity.Role;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.responce.InputDTO;
import com.example.warehouseapp.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    RolesService rolesService;

    @PostMapping("add")
    public HttpEntity<?> add(@RequestBody Role role) throws ParseException {
        ApiResponse response = rolesService.add(role);
        return ResponseEntity.ok(response);
    }

//edit
    //getONe
    //getAll
    //Akmal
}
