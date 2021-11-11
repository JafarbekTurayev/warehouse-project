package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.Category;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.CategoryDTO;
import com.example.warehouseapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse save(CategoryDTO categoryDTO) {
        Category parentCategory = null;
       Category category = new Category();
        if(!categoryRepository.existsByName(categoryDTO.getName())) {
            category.setName(categoryDTO.getName());
            if (categoryDTO.getParentCategoryId()!=null){
                parentCategory = categoryRepository.getById(categoryDTO.getParentCategoryId());
        }
            category.setParentCategory(parentCategory);
            Category save = categoryRepository.save(category);
            return new ApiResponse("Saved!", true,save);
        } else {
            Category byName = categoryRepository.findByName(categoryDTO.getName());
            return new ApiResponse("Bunday category mavjud!", false,byName);
        }
    }

    public ApiResponse delete(Integer id) {
        categoryRepository.deleteById(id);
        return new ApiResponse("Deleted!", true);
    }

    public ApiResponse edit(Integer id, CategoryDTO categoryDTO) {
        Category byIdCategory = categoryRepository.getById(id);
        byIdCategory.setName(categoryDTO.getName());
        byIdCategory.setParentCategory(byIdCategory.getParentCategory());
        categoryRepository.save(byIdCategory);
        return new ApiResponse("Updated!", true, byIdCategory);
    }

    public ApiResponse getAll() {
        List<Category> all = categoryRepository.findAll();
        return  new ApiResponse("Mana", true,all);
    }

    public ApiResponse getOneById(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        return new ApiResponse("Mana",true,byId);
    }

    public ApiResponse deleteAll() {
        categoryRepository.deleteAll();
        return new ApiResponse("Deleted",true);
    }
}

