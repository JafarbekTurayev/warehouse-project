package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.Category;
import com.example.warehouseapp.entity.Warehouse;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.WarehouseDto;
import com.example.warehouseapp.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public ApiResponse save(Warehouse warehouse) {
        if (!warehouseRepository.existsByName(warehouse.getName())) {
            warehouseRepository.save(warehouse);
            return new ApiResponse("Saved!", true);
        }
        return new ApiResponse("Bunday ombor bor!", false);
    }

    public ApiResponse edit(Integer id, WarehouseDto warehouseDto) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);
        warehouse.get().setName(warehouseDto.getName());
        warehouse.get().setActive(warehouseDto.isActive());
        Warehouse save = warehouseRepository.save(warehouse.get());
        return new ApiResponse("Edited", true);
    }

    public ApiResponse getOne(Integer id, WarehouseDto warehouseDto) {
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        return new ApiResponse("Mana",true,byId);
    }

    public ApiResponse getAll() {
        List<Warehouse> all = warehouseRepository.findAll();
        return  new ApiResponse("Mana", true,all);
    }
}
