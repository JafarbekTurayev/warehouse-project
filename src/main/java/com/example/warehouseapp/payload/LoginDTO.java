package com.example.warehouseapp.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;



@Data
public class LoginDTO {

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
