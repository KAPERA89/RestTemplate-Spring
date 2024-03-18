package com.sid.test_rest_template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TestRestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRestTemplateApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){return new RestTemplate();}
}
