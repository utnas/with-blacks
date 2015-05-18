package com.withblacks.business.layers;

import com.withblacks.repository.IUserRepositoryLayer;
import com.withblacks.rest.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserLayer implements IUserLayer {

    private IUserRepositoryLayer repositoryLayer;

    public UserLayer() {
    }

    @Autowired
    public UserLayer( IUserRepositoryLayer repositoryLayer) {
        this.repositoryLayer = repositoryLayer;
    }

    @Override
    public UserDto find(String userName) {
        return new UserDto();
    }

    @Override
    public Iterable<UserDto> findAll() {
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
