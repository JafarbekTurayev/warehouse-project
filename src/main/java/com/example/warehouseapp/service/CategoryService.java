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

    public ApiResponse save(Category category) {
        if(!categoryRepository.existsByName(category.getName())){
            categoryRepository.save(category);
            return new ApiResponse("Saved!",true);
        }else {
            return new ApiResponse("Bunday category mavjud!",false);
        }
    }

    public ApiResponse delete(Integer id) {
            categoryRepository.deleteById(id);
            return new ApiResponse("Deleted!",true);
    }

    public ApiResponse edit(Integer id, CategoryDTO categoryDTO) {
        Category byIdCategory = categoryRepository.getById(id);
        byIdCategory.setName(categoryDTO.getName());
        byIdCategory.setActive(categoryDTO.isActive());
        byIdCategory.setParentCategory(categoryDTO.getParentCategory());
        categoryRepository.save(byIdCategory);
        return new ApiResponse("Updated!",true);
    }

    public List<Category> getAll() {
        List<Category> allCategory = categoryRepository.findAll();
        return allCategory;
    }

    public Category getOneById(Integer id){
        Category byId = categoryRepository.getById(id);
        return byId;
    }


//    public boolean deleted(Integer id) {
//        try {
//            categoryRepository.deleteById(id);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

}

