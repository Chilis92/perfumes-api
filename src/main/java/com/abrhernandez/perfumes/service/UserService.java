package com.abrhernandez.perfumes.service;

import com.abrhernandez.perfumes.entities.Product;
import com.abrhernandez.perfumes.entities.User;
import com.abrhernandez.perfumes.repository.ProductRepository;
import com.abrhernandez.perfumes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    public User save(User user){
        //todo validate obj

        return userRepository.save(user);
    }

    public User findById(String id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void delete(String id){
        userRepository.deleteById(id);
    }

    public User validateCredentials(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }

}
