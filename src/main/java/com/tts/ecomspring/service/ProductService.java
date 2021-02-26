package com.tts.ecomspring.service;


import com.tts.ecomspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(int id) {
        return productRepository.findById(id);
    }
    public List<String> findDistinctBrands(){
        return productRepository.findDistinctBrands();
    }
    public List<String> findDistinctCategory(){
        return productRepository.findDistinctCategory();
    }

    public void save(Product product){
        productRepository.save(product);
    }
    public void deleteById(int id){
        productRepository.deleteById(id);
    }

    public List<Product> findByBrandAndOrCategory(String brand, String category){
        if(category == null && brand == null){
            return productRepository.findAlll();
        }else if(category == null){
            return productRepository.findByBrand(brand);
            return productRepository.findByCategory(category)
        }
    }
}
