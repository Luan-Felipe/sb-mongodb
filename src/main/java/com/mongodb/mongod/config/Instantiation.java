package com.mongodb.mongod.config;

import com.mongodb.mongod.domain.Post;
import com.mongodb.mongod.domain.User;
import com.mongodb.mongod.repository.PostRepository;
import com.mongodb.mongod.repository.UserRepository;
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
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "bob@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2020"), "Partiu viagem", "Vou viajar para o Rio de Janeiro. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2020"), "Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
