package com.withblacks.facade;

import com.withblacks.business.layers.IUserLayer;
import com.withblacks.rest.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeLayer implements IUserFacadeLayer {

    private IUserLayer userLayer;

    public UserFacadeLayer() {
    }

    @Autowired
    public UserFacadeLayer(IUserLayer userLayer) {
        this.userLayer = userLayer;
    }

    @Override
    public UserDto getUser(String userName) {
        return userLayer.find(userName);
    }

    @Override
    public Iterable<UserDto> getUsers() {
        return userLayer.findAll();
    }

    @Override
    public UserDto getUser(long id) {
        return userLayer.find(id);
    }

    @Override
    public UserDto create(UserDto userDto) {
        return userLayer.create(userDto);
    }

    @Override
    public UserDto update(UserDto userDto) {
        return userLayer.update(userDto);
    }

    @Override
    public void remove(long id) {
        userLayer.delete(id);
    }
}
