package com.example.warehouseapp.entity;

import com.example.warehouseapp.entity.template.AbsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Measurement extends AbsEntity {

}
