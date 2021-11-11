package com.example.warehouseapp.controller;

import com.example.warehouseapp.entity.Role;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.responce.InputDTO;
import com.example.warehouseapp.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
