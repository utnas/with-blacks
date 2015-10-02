package com.withblacks;

import com.withblacks.business.seeds.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
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