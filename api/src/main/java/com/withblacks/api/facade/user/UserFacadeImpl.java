package com.withblacks.api.facade.user;

import com.withblacks.api.business.entities.user.User;
import com.withblacks.api.business.layers.user.UserLayer;
import com.withblacks.api.facade.EntityFacade;
import com.withblacks.api.facade.user.dto.UserDto;
import com.withblacks.api.facade.user.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserFacadeImpl implements EntityFacade<UserDto> {

    private UserLayer<User> layer;
    private UserMapper mapper;

    public UserFacadeImpl() {
    }

    @Autowired
    public UserFacadeImpl(final UserLayer<User> layer, final UserMapper mapper) {
        this.layer = layer;
        this.mapper = mapper;
    }

    @Override
    public UserDto getOne(final String userName) throws NoSuchElementException {
        return mapper.convertToDto(layer.find(userName));
    }

    @Override
    public Iterable<UserDto> getAll() {
        return mapper.convertToDtos(layer.findAll());
    }

    @Override
    public UserDto getOne(final Long id) throws NoSuchElementException {
        return mapper.convertToDto(layer.find(id));
    }

    @Override
    public UserDto create(final UserDto dto) throws IllegalArgumentException, NullPointerException, ClassCastException {
        User entity = mapper.convertToUser(dto);
        User user = layer.create(entity);
        return mapper.convertToDto(user);
    }

    @Override
    public UserDto update(final Long id, final UserDto dto) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        final User user = mapper.convertToUser(dto);
        final User update = layer.update(id, user);
        return mapper.convertToDto(update);
    }

    @Override
    public void remove(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        layer.delete(id);
    }
}
