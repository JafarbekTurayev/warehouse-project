package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.Output;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutputRepository extends JpaRepository<Output,Integer> {

List<Output> findAllByClient_Id(Integer client_id);
List<Output> findAllByCurrency_Id(Integer currency_id);
}
