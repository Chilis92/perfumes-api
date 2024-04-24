package com.abrhernandez.perfumes.service;

import com.abrhernandez.perfumes.entities.Product;
import com.abrhernandez.perfumes.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product save(Product product){
        //todo validate obj
        return repository.save(product);
    }

    public Product findById(String id){
        return repository.findById(id).orElse(null);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}
