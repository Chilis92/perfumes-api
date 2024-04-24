package com.abrhernandez.perfumes.entities;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
@AllArgsConstructor
@Builder
public class User {

    private String id;
    private String username;
    private String password;
    private String role;

}
