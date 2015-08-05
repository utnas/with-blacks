package com.withblacks.business.entities;

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

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
