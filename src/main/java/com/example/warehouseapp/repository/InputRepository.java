package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface InputRepository extends JpaRepository<Input, Integer> {

    List<Input> findByCurrency_Id(Integer currency_id);


    List<Input> findAllByDateBetween(Date from, Date to);


}
