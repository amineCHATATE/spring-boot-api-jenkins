package com.amine.springbootapijenkins;

import com.amine.springbootapijenkins.entity.Theme;
import com.amine.springbootapijenkins.repository.ThemeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootApiJenkinsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiJenkinsApplication.class, args);
    }

    @Bean
    public CommandLineRunner sampleData(ThemeRepository repository) {
        return (args) -> {
            repository.save(new Theme("Rollercoaster", "Train ride that speeds you along."));
            repository.save(new Theme("Log flume", "Boat ride with plenty of splashes."));
            repository.save(new Theme("Teacups", "Spinning ride in a giant tea-cup."));
        };
    }
}
