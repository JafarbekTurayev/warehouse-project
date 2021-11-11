package com.example.warehouseapp.repository;

import com.example.warehouseapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

   List<Category> findAllByParentCategoryId(Integer parentCategory_Id);
   Category findByName(String name);
   boolean existsByName(String name);
   boolean existsByParentCategoryId(Integer parentCategory_id);


}
