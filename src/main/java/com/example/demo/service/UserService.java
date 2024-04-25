package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
    	
        Optional<User> user = userRepository.findByUsername(username);
        
        return user.isPresent() && user.get().getPassword().equals(password);
    }
    
    public User createUser(String username, String password) {
    	
        User newUser = new User();
        
        newUser.setUsername(username);
        
        newUser.setPassword(password); 
        
        return userRepository.save(newUser);
    }

}


