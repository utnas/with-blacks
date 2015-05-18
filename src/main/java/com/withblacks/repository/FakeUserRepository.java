package com.withblacks.repository;

import com.withblacks.rest.UserDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FakeUserRepository implements IUserRepositoryLayer {

    public FakeUserRepository() {
    }

    @Override
    public UserDto find(String userName) {
        return new UserDto();
    }

    @Override
    public List<UserDto> findAll() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public UserDto find(long id) {
        return new UserDto();
    }

    @Override
    public UserDto create(UserDto userDto) {
        return new UserDto();
    }

    @Override
    public UserDto update(UserDto userDto) {
        return new UserDto();
    }

    @Override
    public void delete(long id) {
        // Do delete
    }
}
