package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.Supplier;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
   List<Supplier> findByNameStartsWithIgnoreCase(String name);
}
