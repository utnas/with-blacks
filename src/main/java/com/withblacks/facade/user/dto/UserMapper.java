package com.withblacks.facade.user.dto;

import com.withblacks.business.entities.user.User;
import com.withblacks.business.entities.user.UserBuilder;
import com.withblacks.facade.project.dto.ProjectMapper;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.EMPTY_LIST;

@Component
public class UserMapper {

    private DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
    private ProjectMapper projectMapper;

    public UserMapper(){
    }

    public UserMapper(final ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    public User convertToUser(final UserDto dto) {
        return new UserBuilder()
                .setFirstName(dto.getFirstName())
                .setLastName(dto.getLastName())
                .setGender(dto.getGender())
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
            final List<UserDto> userDtos = newArrayList();
            for (final User user : users) {
                userDtos.add(convertToDto(user));
            }
            return userDtos;
        } catch (IndexOutOfBoundsException e) {
            return EMPTY_LIST;
        }
    }
}
