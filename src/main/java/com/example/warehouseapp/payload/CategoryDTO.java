package com.example.warehouseapp.payload;

import com.example.warehouseapp.entity.Category;
import lombok.Data;

@Data
public class CategoryDTO {
//    private Integer id;
    private String name;
    private boolean active = true;
    private Integer parentCategoryId;

}
