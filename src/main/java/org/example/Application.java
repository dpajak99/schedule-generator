package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = "org.example.infra.repositories.jpa")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
