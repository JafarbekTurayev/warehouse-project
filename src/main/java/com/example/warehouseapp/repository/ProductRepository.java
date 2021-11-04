package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByCode(String code);

    List<Product> findByCategory_Id(Integer category_id);

    boolean existsByName(String name);
}
