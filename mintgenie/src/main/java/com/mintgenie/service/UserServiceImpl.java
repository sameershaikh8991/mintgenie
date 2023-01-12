package com.mintgenie.service;

import com.mintgenie.exceptions.NotfoundException;
import com.mintgenie.model.User;
import com.mintgenie.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepo userRepo;

    public User saveUser(User user) {
        userRepo.save(user);
        return user;
    }

    public User getById(int id) {
        // userRepo.findById(id).get();
        return userRepo.findById(id).orElseThrow(() -> new NotfoundException(id));
    }
}
