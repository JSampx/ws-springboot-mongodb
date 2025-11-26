package com.jsan.workshop_mongodb.services;

import com.jsan.workshop_mongodb.domain.User;
import com.jsan.workshop_mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsan.workshop_mongodb.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        User user = repo.findById(id).orElseThrow(()->new ObjectNotFoundException(id));
        return user;
    }
}
