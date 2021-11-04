package com.example.warehouseapp.service;

import com.example.warehouseapp.entity.Product;
import com.example.warehouseapp.payload.ApiResponse;
import com.example.warehouseapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public ApiResponse saveProduct(Product product) {
        if (!productRepository.existsByName(product.getName())) {
            productRepository.save(product);
            return new ApiResponse("Saved!", true);
        }
        return new ApiResponse("Bunday mahsulot bor!", false);
    }



    public List<Product> getAllProduct(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Product> allProduct = productRepository.findAll(pageable);
        return allProduct.getContent();
    }

    public Product getOneById(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        return byId.orElse(null);
    }

    public Product editProduct(Integer id, Product product) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()){
            Product editProduct = byId.get();
            editProduct.setName(product.getName());
            editProduct.setCode(product.getCode());
            editProduct.setCategory(product.getCategory());
            editProduct.setMeasurement(product.getMeasurement());
            editProduct.setPhotoId(product.getPhotoId());
            editProduct.setActive(product.isActive());
            return productRepository.save(editProduct);
        }
        return null;
    }

    public boolean deleted(Integer id) {
        try {
            productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
