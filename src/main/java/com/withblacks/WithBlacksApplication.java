package com.withblacks;

import com.withblacks.business.entities.project.ProjectBuilder;
import com.withblacks.business.entities.user.UserBuilder;
import com.withblacks.repository.project.ProjectRepository;
import com.withblacks.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import static com.withblacks.business.entities.user.GENDER.FEMALE;
import static com.withblacks.business.entities.user.GENDER.MALE;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@PropertySource("classpath:application.properties")
public class WithBlacksApplication implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(WithBlacksApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        userRepository.save(new UserBuilder()
                .setFirstName("Iron")
                .setLastName("Man")
                .setGender(MALE).build());

        userRepository.save(new UserBuilder()
                .setFirstName("Super")
                .setLastName("Man")
                .setGender(MALE).build());

        userRepository.save(new UserBuilder()
                .setFirstName("Cat")
                .setLastName("Woman")
                .setGender(FEMALE).build());

        userRepository.save(new UserBuilder()
                .setFirstName("Spider")
                .setLastName("Man")
                .setGender(MALE).build());

        projectRepository.save(new ProjectBuilder()
                .setName("SPM-st").build());

        projectRepository.save(new ProjectBuilder()
                .setName("Arm-st").build());
    }
}
