package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.Category;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.payload.CategoryDTO;
import com.example.warehouseapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse save(CategoryDTO categoryDTO) {
        Optional<Category> categoryParentId = null;
        if (categoryDTO.getParentCategoryId() != null) {
            categoryParentId = categoryRepository.findById(categoryDTO.getParentCategoryId());
        }
        if (!categoryRepository.existsByName(categoryDTO.getName())) {
            Category category = new Category();
            category.setName(categoryDTO.getName());
            if (categoryParentId.isPresent()) {
                category.setParentCategory(categoryParentId.get());
            } else {
                category.setParentCategory(null);
            }
            categoryRepository.save(category);
            return new ApiResponse("Saved!", true);
        } else {
            return new ApiResponse("Bunday category mavjud!", false);
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

    public List<Category> getAll() {
        List<Category> allCategory = categoryRepository.findAll();
        return (List<Category>) new ApiResponse("Mana", true, allCategory);
    }

    public ApiResponse getOneById(Integer id) {
        Category byId = categoryRepository.getById(id);
        return new ApiResponse("Mana", true, byId);
    }

}

