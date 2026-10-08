package com.example.warehouseapp.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String phoneNumber;


}

