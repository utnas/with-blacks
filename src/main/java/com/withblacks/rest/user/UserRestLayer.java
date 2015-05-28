package com.withblacks.rest.user;

import com.withblacks.business.GENDER;
import com.withblacks.facade.user.IUserFacadeLayer;
import com.withblacks.rest.user.trasformer.IUserDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserRestLayer implements IUserRestLayer {

    private IUserFacadeLayer userFacadeLayer;
    private IUserDtoTransformer transformer;

    public UserRestLayer() {
    }

    @Autowired
    public UserRestLayer(IUserFacadeLayer userFacadeLayer, IUserDtoTransformer transformer) {
        this.userFacadeLayer = userFacadeLayer;
        this.transformer = transformer;
    }

    @RequestMapping(value = "/users/", method = GET, headers = "Accept=application/json")
    public Iterable<UserDto> findAll() {
        return transformer.transform(
                userFacadeLayer.getUsers()
        );
    }

    @RequestMapping(method = GET)
    public UserDto findByName(@RequestParam final String name) {
        return transformer.transform(
                userFacadeLayer.getUser(name)
        );
    }

    @RequestMapping(value = "/users/{id}", method = GET)
    public UserDto findById(@RequestParam final long id) {
        return transformer.transform(
                userFacadeLayer.getUser(id)
        );
    }

    @RequestMapping(value = "/createUser", method = POST)
    public boolean create(@RequestParam final String firstName, @RequestParam final String lastName, @RequestParam final GENDER gender) {
        return userFacadeLayer.create(
                transformer.transform(new UserDto(firstName, lastName, gender))
        );
    }

    @RequestMapping(method = PUT)
    public boolean update(@RequestParam final String firstName, @RequestParam final String lastName, @RequestParam final GENDER gender) {
        // We should call a transformer instead of using DTO
        return userFacadeLayer.update(
                transformer.transform(
                        new UserDto(firstName, lastName, gender)
                )
        );
    }

    @RequestMapping(method = DELETE)
    public void delete(@RequestParam final long id) {
        userFacadeLayer.remove(id);
    }
}
