package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.*;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;


@Service
public class RolesService {

    @Autowired
    RoleRepository roleRepository;

    public ApiResponse add(Role role) throws ParseException {
    Role newRole = new Role();
    if (!roleRepository.existsByName(role.getName()))
        newRole = roleRepository.save(
                new Role(role.getId(), role.getName(), role.isActive(), role.getPermissions())
        );

        return new ApiResponse("Saved!", true, newRole);
    }
}
