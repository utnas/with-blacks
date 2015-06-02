package com.withblacks.rest.user;

import com.withblacks.business.entity.GENDER;
import com.withblacks.facade.user.IUserFacadeLayer;
import com.withblacks.rest.user.trasformer.IUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.withblacks.rest.user.trasformer.UserDtoBuilder.build;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserRestLayer implements IUserRestLayer {

    private IUserFacadeLayer userFacadeLayer;
    private IUserTransformer<com.withblacks.business.entity.User, UserDto> transformer;

    public UserRestLayer() {
    }

    @Autowired
    public UserRestLayer(IUserFacadeLayer userFacadeLayer, IUserTransformer<com.withblacks.business.entity.User, UserDto> transformer) {
        this.userFacadeLayer = userFacadeLayer;
        this.transformer = transformer;
    }

    @RequestMapping(value = "/users/", method = GET, headers = "Accept=application/json")
    public Iterable findAll() {
        return transformer.convertTo(
                userFacadeLayer.getUsers()
        );
    }

    @RequestMapping(method = GET)
    public UserDto findByName(@RequestParam final String name) {
        return transformer.convertTo(
                userFacadeLayer.getUser(name)
        );
    }

    @RequestMapping(value = "/users/{id}", method = GET)
    public UserDto findById(@RequestParam final long id) {
        return transformer.convertTo(
                userFacadeLayer.getUser(id)
        );
    }

    @RequestMapping(value = "/build", method = POST)
    @ResponseBody
    public boolean create(@RequestParam final String firstName, @RequestParam final String lastName, @RequestParam final GENDER gender) {
        return userFacadeLayer.create(
                transformer.convertFrom(build(firstName, lastName, gender))
        );
    }

    @RequestMapping(method = PUT)
    public boolean update(@RequestParam final String firstName, @RequestParam final String lastName, @RequestParam final GENDER gender) {
        return userFacadeLayer.update(
                transformer.convertFrom(
                        build(firstName, lastName, gender)
                )
        );
    }

    @RequestMapping(method = DELETE)
    public void delete(@RequestParam final long id) {
        userFacadeLayer.remove(id);
    }
}
