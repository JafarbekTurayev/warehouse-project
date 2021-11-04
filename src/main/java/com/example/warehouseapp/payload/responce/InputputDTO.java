package com.example.warehouseapp.payload.responce;

import com.example.warehouseapp.entity.Currency;
import com.example.warehouseapp.entity.Warehouse;
import lombok.Data;

import java.util.Date;

@Data
public class InputputDTO {
    private Date date;
    private Warehouse warehouse;
    private Currency currency;
    private String factureName;
}
