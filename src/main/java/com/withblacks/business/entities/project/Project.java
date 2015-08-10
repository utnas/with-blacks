package com.withblacks.business.entities.project;

import com.withblacks.business.entities.user.User;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "Projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne
    private User members;

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
