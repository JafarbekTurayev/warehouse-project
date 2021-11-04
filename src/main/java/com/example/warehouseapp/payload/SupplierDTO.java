package com.example.warehouseapp.payload;

import com.example.warehouseapp.entity.Supplier;
import com.example.warehouseapp.service.SupplierServise;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class SupplierDTO {
    @NotNull
    private String name;

    public SupplierDTO(String name) {
        this.name = name;
    }
}
