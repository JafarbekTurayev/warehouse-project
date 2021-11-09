package com.example.warehouseapp.payload;

import com.example.warehouseapp.entity.Category;
import lombok.Data;

@Data
public class CategoryDTO {
    private String name;
    private Integer parentCategoryId;

}
