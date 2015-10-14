package com.withblacks.api.facade.user.dto;

import com.google.common.base.Function;
import com.withblacks.api.business.entities.user.UserBuilder;
import com.withblacks.api.business.entities.user.User;
import com.withblacks.api.facade.project.dto.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import java.util.List;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;

@Component
public class UserMapper {

    private ProjectMapper projectMapper;

    public UserMapper() {
    }

    @Autowired
    public UserMapper(final ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    public User convertToUser(final UserDto dto) {
        return new UserBuilder()
                .setFirstName(dto.getFirstName())
                .setLastName(dto.getLastName())
                .setGender(dto.getGender())
                .setCredentials(dto.getCredentials())
                .setProjects(projectMapper.convertToProjects(dto.getProjects())).build();
    }

    public UserDto convertToDto(final User user) {
        return new UserDtoBuilder()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setProjects(projectMapper.convertToDtos(user.getProjects()))
                .setGender(user.getGender()).build();
    }

    public List<UserDto> convertToDtos(final Iterable<User> users) {
        try {
            return newArrayList(transform(users, toUserDtoFunction()));
        } catch (NullPointerException e) {
            return emptyList();
        }
    }

    private Function<User, UserDto> toUserDtoFunction() {
        return new Function<User, UserDto>() {
            @Nullable
            public UserDto apply(User input) {
                return convertToDto(input);
            }
        };
    }
}
