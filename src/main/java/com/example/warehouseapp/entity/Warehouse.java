package com.example.warehouseapp.entity;

import com.example.warehouseapp.entity.template.AbsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Warehouse  extends AbsEntity {

}
