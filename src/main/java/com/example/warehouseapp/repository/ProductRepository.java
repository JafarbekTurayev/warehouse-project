package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByCode(String code);

    List<Product> findByCategory_Id(Integer category_id);

    boolean existsByName(String name);

    @Query(value = "select sum(ip.amount) as summa, p.name from product p " +
            "inner join input_product ip on p.id = ip.product_id " +
            "group by p.name order by summa desc limit 10", nativeQuery = true)
    List<Object[]> getTopInputProducts();

    @Query(value = "select sum(ip.amount) as summa, p.name from product p " +
            "inner join input_product ip on p.id = ip.product_id " +
            "group by p.name order by summa asc limit 10", nativeQuery = true)
    List<Object[]> getLessInputProducts();

    Optional<Product> findByName(String name);
}
