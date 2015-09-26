package com.withblacks;

import com.withblacks.business.seeding.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@EnableConfigurationProperties
@PropertySource("classpath:application.properties")
public class WithBlacksApplication implements ApplicationRunner {

    @Autowired
    private Seed seed;

    public static void main(String[] args) {
        SpringApplication.run(WithBlacksApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seed.populate();
    }
}