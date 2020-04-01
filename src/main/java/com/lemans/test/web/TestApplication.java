package com.lemans.test.web;

import com.lemans.test.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(TestApplication.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate){
        return args -> {
            User[] users = restTemplate.getForObject(
                    "https://jsonplaceholder.typicode.com/posts", User[].class);
            logger.info("Users:" + Arrays.toString(users));


//            I.	List all the posts that have userId >3 and userId < 8
            assert users != null;
            List<String> posts = Arrays.stream(users)
                    .filter(user -> user.getId() > 3 && user.getId() < 8).map(User::getBody).collect(Collectors.toList());
            posts.forEach(System.out::println);

//            II.	Group all the posts by userId and id
            Map<Integer, List<User>> postsByByUserId = Arrays.stream(users)
                    .collect(Collectors.groupingBy(User::getUserId));
            postsByByUserId.forEach((k, v) -> System.out.println("Key: " + k + "value" + v));

            Map<Integer, List<User>> postsByById = Arrays.stream(users)
                    .collect(Collectors.groupingBy(User::getId));
            postsByByUserId.forEach((k, v) -> System.out.println("Key: " + k + "value" + v));

//            III.	Add a new field called sequence and insert a random value in to it.
            List<User> usersWithSequence = Arrays.stream(users)
                    .map(user -> {
                        user.setSequence(Integer.toString(Arrays.asList(users).indexOf(user)));
                        return user;
                    }).collect(Collectors.toList());
            usersWithSequence.forEach(System.out::println);

        };
    }
}
