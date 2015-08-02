package com.withblacks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@PropertySource("classpath:application.properties")
public class WithBlacksApplication {

    private static Logger logger = LoggerFactory.getLogger(WithBlacksApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WithBlacksApplication.class, args);
    }
}
