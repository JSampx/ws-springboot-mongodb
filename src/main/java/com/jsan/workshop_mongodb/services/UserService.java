package com.jsan.workshop_mongodb.services;

import com.jsan.workshop_mongodb.domain.User;
import com.jsan.workshop_mongodb.dto.UserDTO;
import com.jsan.workshop_mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsan.workshop_mongodb.repository.UserRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
  }
}
