package com.example.warehouseapp.entity;

import com.example.warehouseapp.entity.enums.Permission;
import com.example.warehouseapp.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends AbsEntity {

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Permission> permissions;

    public Role(Integer id, String name, boolean active, Set<Permission> permissions) {
        super(id, name, active);
        this.permissions = permissions;
        
    }
}
