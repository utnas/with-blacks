package com.withblacks.api.business.seeds;

import com.withblacks.api.business.entities.user.GENDER;
import com.withblacks.api.business.entities.project.Project;
import com.withblacks.api.business.entities.project.ProjectBuilder;
import com.withblacks.api.business.entities.user.UserBuilder;
import com.withblacks.api.repository.ProjectRepository;
import com.withblacks.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Seed {
    private  UserRepository userRepository;
    private  ProjectRepository projectRepository;

    public Seed(){}

    @Autowired
    public Seed(final UserRepository userRepository, final ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    public void populate() {
        Project spmST = new ProjectBuilder()
                .setName("SPM-st").build();
        Project armST = new ProjectBuilder()
                .setName("Arm-st").build();

        projectRepository.save(spmST);

        projectRepository.save(armST);

        userRepository.save(new UserBuilder()
                .setFirstName("Iron")
                .setLastName("Man")
                .setGender(GENDER.MALE)
                .addProjects(spmST).build());

        userRepository.save(new UserBuilder()
                .setFirstName("Super")
                .setLastName("Man")
                .setGender(GENDER.MALE)
                .addProjects(armST).build());

        userRepository.save(new UserBuilder()
                .setFirstName("Cat")
                .setLastName("Woman")
                .setGender(GENDER.FEMALE).build());

        userRepository.save(new UserBuilder()
                .setFirstName("Spider")
                .setLastName("Man")
                .setGender(GENDER.MALE).build());
    }
}
