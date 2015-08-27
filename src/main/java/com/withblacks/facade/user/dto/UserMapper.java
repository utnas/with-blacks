package com.withblacks.facade.user.dto;

import com.google.common.base.Function;
import com.withblacks.business.entities.user.User;
import com.withblacks.business.entities.user.UserBuilder;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import static com.google.common.collect.Iterables.transform;
import static java.util.Collections.EMPTY_LIST;

@Component
public class UserMapper {

    private DozerBeanMapper mapper;

    public UserMapper() {
        mapper = new DozerBeanMapper();
    }

    public User convertToUser(final UserDto dto) {
        return new UserBuilder()
                .setFirstName(dto.getFirstName())
                .setLastName(dto.getLastName())
                .setGender(dto.getGender())
                .setProjects(dto.getProjects()).build();
    }

    public UserDto convertToDto(final User user) {
        return new UserDtoBuilder()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setProjects(user.getProjects())
                .setGender(user.getGender()).build();
    }

    public Iterable<UserDto> convertToDtos(final Iterable<User> users) {
        try {
            return transform(users, toDto());
        } catch (IndexOutOfBoundsException e) {
            return EMPTY_LIST;
        }
    }

    private Function<User, UserDto> toDto() {
        return input -> convertToDto(input);
    }
}
