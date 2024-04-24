package com.abrhernandez.perfumes.controller;

import com.abrhernandez.perfumes.entities.Product;
import com.abrhernandez.perfumes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Product> save(@RequestPart("product") Product product, @RequestPart("file") MultipartFile multipart){

        try {
            Binary binary = new Binary(BsonBinarySubType.BINARY, multipart.getBytes());
            product.setFile(binary);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<Product> findById(@PathVariable("product-id") String productId){
        return ResponseEntity.ok(productService.findById(productId));
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void> delete(@PathVariable("product-id") String productId){
        productService.delete(productId);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

}
