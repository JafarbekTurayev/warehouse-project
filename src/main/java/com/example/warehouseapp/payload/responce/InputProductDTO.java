package com.example.warehouseapp.payload.responce;

import com.example.warehouseapp.entity.Input;
import com.example.warehouseapp.entity.Product;
import lombok.Data;
import java.util.Date;

@Data
public class InputProductDTO {
    private Product product;
    private Double amount;
    private Double price;
    private Date expireDate;
    private Input input;
}
