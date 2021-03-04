package com.github.elijasp.workouttracker.services;

import com.github.elijasp.workouttracker.domain.User;
import com.github.elijasp.workouttracker.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // == fields ==
    private UserRepository repository;
    // == constructor ==
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public User saveUser(User user){
        User savedUsed = repository.save(user);
        return savedUsed;
    }
}
