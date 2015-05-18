package com.withblacks.facade;

import com.withblacks.business.User;
import com.withblacks.business.layers.IUserLayer;
import com.withblacks.rest.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User getUser(String userName) {
        return userLayer.find(userName);
    }

    @Override
    public List<User> getUsers() {
        return userLayer.findAll();
    }

    @Override
    public User getUser(long id) {
        return userLayer.find(id);
    }

    @Override
    public User create(User userDto) {
        return userLayer.create(userDto);
    }

    @Override
    public User update(User userDto) {
        return userLayer.update(userDto);
    }

    @Override
    public void remove(long id) {
        userLayer.delete(id);
    }
}
