package com.withblacks.rest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan
class RestMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestMockApplication.class, args);
    }
}
