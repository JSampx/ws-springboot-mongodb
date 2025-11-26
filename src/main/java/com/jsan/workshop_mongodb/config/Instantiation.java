package com.jsan.workshop_mongodb.config;

import com.jsan.workshop_mongodb.domain.User;
import com.jsan.workshop_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {

        userRepository.deleteAll();

        User john = new User(null, "John", "john@email.com");
        User terry = new User(null, "Terry", "terry@email.com");
        User chris = new User(null, "Chris", "chris@email.com");

        userRepository.saveAll(Arrays.asList(john, terry, chris));

    }
}
