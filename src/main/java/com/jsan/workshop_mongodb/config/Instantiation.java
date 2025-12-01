package com.jsan.workshop_mongodb.config;

import com.jsan.workshop_mongodb.domain.Post;
import com.jsan.workshop_mongodb.domain.User;
import com.jsan.workshop_mongodb.dto.AuthorDTO;
import com.jsan.workshop_mongodb.repository.PostRepository;
import com.jsan.workshop_mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... strings) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User john = new User(null, "John", "john@email.com");
        User terry = new User(null, "Terry", "terry@email.com");
        User chris = new User(null, "Chris", "chris@email.com");

        userRepository.saveAll(Arrays.asList(john, terry, chris));

        Post post1 = new Post(null, sdf.parse("12/12/2025"),"Titulo do post1", "Corpo da mensagem do post1", new AuthorDTO(john));
        Post post2 = new Post(null, sdf.parse("13/12/2025"),"Titulo do Post2", "Corpo da mensagem do post2", new AuthorDTO(chris));


        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
