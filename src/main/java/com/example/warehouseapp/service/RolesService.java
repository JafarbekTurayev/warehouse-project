package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.Role;
import com.example.warehouseapp.exception.ResourceNotFoundException;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;


@Service
public class RolesService {

    @Autowired
    RoleRepository roleRepository;

    public ApiResponse add(Role role) throws ParseException {
        if (roleRepository.existsByName(role.getName()))
            return new ApiResponse("This role already exists", false);

        Role newRole = roleRepository.save(
                new Role(null, role.getName(), role.isActive(), role.getPermissions())
        );
        return new ApiResponse("Saved!", true, newRole);
    }

    public ApiResponse getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Role> rolePage = roleRepository.findAll(pageable);
        return new ApiResponse("Roles", true, rolePage);
    }

    public Role getOne(Integer id) {
        Optional<Role> optional = roleRepository.findById(id);
        return optional.orElseThrow(() -> new ResourceNotFoundException("role", "id", id));
    }

    public ApiResponse edit(Integer id, Role dto) {
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent()){

            Role role = optional.get();

            if (dto.getName()!=null) {
                role.setName(dto.getName());
            }


            if (dto.getPermissions()!=null) {
                role.setPermissions(dto.getPermissions());
            }

            Role save = roleRepository.save(role);
            return new ApiResponse("Role edited", true,save);

        }else {
            return new ApiResponse("Role not found", false);
        }
    }

    public ApiResponse delete(Integer id) {
        Optional<Role> byId = roleRepository.findById(id);
        if (byId.isPresent()){
            Role role = byId.get();
            role.setActive(false);
            Role save = roleRepository.save(role);
            return new ApiResponse("Role deactivated", true, save);
        }
        return new ApiResponse("Role not found", false);

    }
}
