package com.example.warehouseapp.entity;

import com.example.warehouseapp.entity.template.AbsEntity;
import com.example.warehouseapp.payload.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends AbsEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    private Category parentCategory;
}
