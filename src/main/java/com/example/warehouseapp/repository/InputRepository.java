package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InputRepository extends JpaRepository<Input,Integer> {

    List<Input> findBySupplier_Id(Integer supplier_id);
    List<Input> findByCurrency_Id(Integer currency_id);

}
