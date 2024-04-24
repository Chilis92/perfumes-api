package com.abrhernandez.perfumes.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
@AllArgsConstructor
@Builder
public class Product {

    private String id;
    private String name;
    private String description;
    private Boolean enabled;
    private Double price;
    private String brand;
    @Field
    private Binary file;


}
