package com.abrhernandez.perfumes.repository;

import com.abrhernandez.perfumes.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends MongoRepository<User,String> {

    @Query(value = "{'username' : :#{#username}, 'password' : :#{#password}}")
    User findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
}
