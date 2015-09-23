package com.withblacks.business.entities.project;

import com.withblacks.business.entities.user.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
@Entity
@Table(name = "Projects")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany
    private final List<User> members = newArrayList();

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addMember(final User user) {
        return members.add(user);
    }

    public Iterable<User> getMembers() {
        return members;
    }

    public boolean addMembers(final List<User> members) {
        return this.members.addAll(members);
    }
}
