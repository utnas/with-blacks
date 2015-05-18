package com.withblacks.facade;

import com.withblacks.repository.IUserRepositoryLayer;
import com.withblacks.rest.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeLayer implements IUserFacadeLayer {

    @Autowired
    private IUserRepositoryLayer userRepositoryLayer;

    public UserFacadeLayer() {
    }

    public UserFacadeLayer(IUserRepositoryLayer userRepositoryLayer) {
        this.userRepositoryLayer = userRepositoryLayer;
    }

    @Override
    public UserDto getUser(final String userName) {
        return userRepositoryLayer.find(userName);
    }

    @Override
    public Iterable<UserDto> getUsers() {
        return userRepositoryLayer.findAll();
    }

    @Override
    public UserDto getUser(final long id) {
        return userRepositoryLayer.find(id);
    }

    @Override
    public UserDto create(final UserDto userDto) {
        return userRepositoryLayer.create(userDto);
    }

    @Override
    public UserDto update(final UserDto userDto) {
        return userRepositoryLayer.update(userDto);
    }

    @Override
    public void remove(final long id) {
        userRepositoryLayer.delete(id);
    }
}
