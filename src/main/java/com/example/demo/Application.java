package com.example.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@SpringBootApplication
@Component

public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);

    }

    // to have some code running after the application starter use 👇️
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student Ash = new Student(
                    "Ashly",
                    "Apondi",
                    "ash@gmail.com"
            );
            Student Jimmy = new Student(
                    "Jimmy",
                    "Kibaki",
                    "kibakijimmy@gmail.com"

            );
            Student Eras = new Student(
                    "eras",
                    "muriithi",
                    "eras@gmail.com"
            );
            Student Peterson = new Student(
                    "peterson",
                    "Maina",
                    "maina@gmail.com"

            );
            Student tito = new Student(
                    "tito",
                    "waweru",
                    "mainatito@gmail.com"

            );
            studentRepository.saveAll(
                    List.of(
                            Ash,
                            Jimmy,
                            Eras,
                            Peterson,
                            tito
                    )
            );
        };
    }
    }







