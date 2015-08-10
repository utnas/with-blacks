package com.withblacks.facade.user.dto;

import com.withblacks.business.entities.user.UserBuilder;
import com.withblacks.business.entities.user.User;
import com.withblacks.facade.user.dto.UserDto;
import com.withblacks.facade.user.dto.UserDtoBuilder;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class UserMapper {

    private DozerBeanMapper mapper;

    public UserMapper() {
        mapper = new DozerBeanMapper();
    }

    public User convertToUser(final UserDto dto) {
        final User user = new UserBuilder()
                .setFirstName(dto.getFirstName())
                .setLastName(dto.getLastName())
                .setGender(dto.getGender()).build();
        return user;
    }

    public UserDto convertToDto(final User user) {
        final UserDto dto = new UserDtoBuilder()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setGender(user.getGender()).build();
        return dto;
    }

    public Iterable<UserDto> convertToDtos(final Iterable<User> users) {
        final Collection<UserDto> dtos = newArrayList();
        for (final User user : users) {
            dtos.add(convertToDto(user));
        }
        return dtos;
    }
}
