package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.Category;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse save(Category category) {
        if(!categoryRepository.existsByName(category.getName())){
            categoryRepository.save(category);
            return new ApiResponse("Saved!",true);
        }else {
            return new ApiResponse("Bunday category mavjud!",false);
        }

    }

    public ApiResponse delete(Category category) {
        if(categoryRepository.existsByName(category.getName())){
            categoryRepository.delete(category);
            return new ApiResponse("Deleted!",true);
        }else {
            return new ApiResponse("Category ni O`chirib Bo`lmadi!",false);
        }

    }

    public ApiResponse update(Category category) {
        Category byIdCategory = categoryRepository.getById(category.getId());
        byIdCategory.setName(category.getName());
        byIdCategory.setActive(category.isActive());
        byIdCategory.setParentCategory(category.getParentCategory());

        return new ApiResponse("Updated!",true);
    }

    public List<Category> getAll() {
        List<Category> allCategory = categoryRepository.findAll();
        return allCategory;
    }
}

