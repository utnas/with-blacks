package com.withblacks.rest.user;

import com.withblacks.business.entity.GENDER;
import com.withblacks.facade.user.IUserFacadeLayer;
import com.withblacks.rest.user.trasformer.IUserTransformer;
import com.withblacks.rest.user.trasformer.UserDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.withblacks.rest.user.trasformer.UserDtoBuilder.build;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserRestLayer implements IUserRestLayer {

    private IUserFacadeLayer userFacadeLayer;
    private IUserTransformer transformer;

    public UserRestLayer() {
    }

    @Autowired
    public UserRestLayer(IUserFacadeLayer userFacadeLayer, IUserTransformer transformer) {
        this.userFacadeLayer = userFacadeLayer;
        this.transformer = transformer;
    }

    @RequestMapping(value = "/users/", method = GET, headers = "Accept=application/json")
    public Iterable<UserDto> findAll() {
        return transformer.toDtos(
                userFacadeLayer.getUsers()
        );
    }

    @RequestMapping(method = GET)
    public UserDto findByName(@RequestParam final String name) {
        return transformer.toDto(
                userFacadeLayer.getUser(name)
        );
    }

    @RequestMapping(value = "/users/{id}", method = GET)
    public UserDto findById(@RequestParam final long id) {
        return transformer.toDto(
                userFacadeLayer.getUser(id)
        );
    }

    @RequestMapping(value = "/build", method = POST)
    public boolean create(@RequestParam final String firstName, @RequestParam final String lastName, @RequestParam final GENDER gender) {
        return userFacadeLayer.create(
                transformer.toUser(build(firstName, lastName, gender))
        );
    }

    @RequestMapping(method = PUT)
    public boolean update(@RequestParam final String firstName, @RequestParam final String lastName, @RequestParam final GENDER gender) {
        return userFacadeLayer.update(
                transformer.toUser(
                        build(firstName, lastName, gender)
                )
        );
    }

    @RequestMapping(method = DELETE)
    public void delete(@RequestParam final long id) {
        userFacadeLayer.remove(id);
    }
}
