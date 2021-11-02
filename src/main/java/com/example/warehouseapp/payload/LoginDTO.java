package com.example.warehouseapp.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    @NotNull(message = "Username yoz iltimos!")
    private String userName;
    @NotNull(message = "Password yozing iltimos")
    private String password;
}
