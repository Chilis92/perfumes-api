package com.abrhernandez.perfumes.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
public class UserRequest {
    private String username;
    private String password;
}
