package com.withblacks.business.seeds;

import com.withblacks.business.entities.project.Project;
import com.withblacks.business.entities.project.ProjectBuilder;
import com.withblacks.business.entities.user.UserBuilder;
import com.withblacks.repository.project.ProjectRepository;
import com.withblacks.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.withblacks.business.entities.user.GENDER.FEMALE;
import static com.withblacks.business.entities.user.GENDER.MALE;

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
                .setGender(MALE)
                .addProjects(spmST).build());

        userRepository.save(new UserBuilder()
                .setFirstName("Super")
                .setLastName("Man")
                .setGender(MALE)
                .addProjects(armST).build());

        userRepository.save(new UserBuilder()
                .setFirstName("Cat")
                .setLastName("Woman")
                .setGender(FEMALE).build());

        userRepository.save(new UserBuilder()
                .setFirstName("Spider")
                .setLastName("Man")
                .setGender(MALE).build());
    }
}
