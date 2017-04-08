package com.bliblifuture.service;

import com.bliblifuture.model.User;
import com.bliblifuture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public List<User> findAll(){
        List<User> data = userRepo.findAll();
        return data;
    }
}
