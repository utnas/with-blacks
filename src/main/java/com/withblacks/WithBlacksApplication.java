package com.withblacks;

import com.withblacks.business.builder.UserBuilder;
import com.withblacks.repository.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import static com.withblacks.business.entities.GENDER.FEMALE;
import static com.withblacks.business.entities.GENDER.MALE;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@PropertySource("classpath:application.properties")
public class WithBlacksApplication implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(WithBlacksApplication.class);
    @Autowired
    UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(WithBlacksApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        repository.save(new UserBuilder()
                .setFirstName("Iron")
                .setLastName("Man")
                .setGender(MALE).build());

        repository.save(new UserBuilder()
                .setFirstName("Super")
                .setLastName("Man")
                .setGender(MALE).build());

        repository.save(new UserBuilder()
                .setFirstName("Cat")
                .setLastName("Woman")
                .setGender(FEMALE).build());

        repository.save(new UserBuilder()
                .setFirstName("Spider")
                .setLastName("Man")
                .setGender(MALE).build());
    }
}
