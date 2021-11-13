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
        boolean existsByName = categoryRepository.existsByName(categoryDTO.getName());

        if (existsByName){
            return new ApiResponse("This Category already exist!!", false);
        }

        Category category = new Category();
        category.setName(categoryDTO.getName());

        if(categoryDTO.getParentCategoryId() != null){
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDTO.getParentCategoryId());
            if(!optionalCategory.isPresent())
                return new ApiResponse("Category Not Found!",false);
            category.setParentCategory(categoryRepository.getById(categoryDTO.getParentCategoryId()));
        }

        categoryRepository.save(category);
        Category byName = categoryRepository.findByName(category.getName());

        return new ApiResponse("Saved", true,byName);
    }

    public ApiResponse delete(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (!optionalCategory.isPresent())
            return new ApiResponse("Category Not Found", false);
        categoryRepository.deleteById(id);
        return new ApiResponse("Deleted!", true);
    }

    public ApiResponse edit(Integer id, CategoryDTO categoryDTO) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (!optionalCategory.isPresent())
            return new ApiResponse("Category Not Found", false);

        Category category = optionalCategory.get();
        category.setName(categoryDTO.getName());

        if(categoryDTO.getParentCategoryId() != null){
            Optional<Category> optional = categoryRepository.findById(categoryDTO.getParentCategoryId());
            if(!optional.isPresent())
                return new ApiResponse("Category Not Found",false);

            category.setParentCategory(categoryRepository.getById(categoryDTO.getParentCategoryId()));
        }

        Category save = categoryRepository.save(category);

        return new ApiResponse("Edited!", true,save);


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
        return new ApiResponse("All Category Deleted!",true);
    }

    public ApiResponse getChildCategories(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        List<Category> childCategories = categoryRepository.findAllByParentCategoryId(id);
        return new ApiResponse("Mana",true,childCategories);
    }

}

