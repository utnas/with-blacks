package com.withblacks.rest.user;

import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import com.withblacks.facade.user.IUserFacadeLayer;
import com.withblacks.rest.user.trasformer.IUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.withblacks.rest.user.trasformer.UserDtoBuilder.build;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserRestLayer implements IUserRestLayer {

    private IUserFacadeLayer userFacadeLayer;
    private IUserTransformer<User, UserDto> transformer;

    public UserRestLayer() {
    }

    @Autowired
    public UserRestLayer(IUserFacadeLayer userFacadeLayer, IUserTransformer<User, UserDto> transformer) {
        this.userFacadeLayer = userFacadeLayer;
        this.transformer = transformer;
    }

    @RequestMapping(value = "/users/", method = GET)
    public Iterable findAll() {
        System.out.println("FindAll");
        return transformer.convertTo(
                userFacadeLayer.getUsers()
        );
    }

    @RequestMapping(value = "/users/{name}",method = GET)
    public UserDto findByName(@RequestParam final String name) {
        System.out.println("findByName " + name);
        return transformer.convertTo(
                userFacadeLayer.getUser(name)
        );
    }

    @RequestMapping(value = "/users/{id}", method = GET)
    public UserDto findById(@RequestParam final long id) {
        System.out.println("findById " + id);
        return transformer.convertTo(
                userFacadeLayer.getUser(id)
        );
    }

    @RequestMapping(value = "/users", method = POST)
    @ResponseBody
    public boolean create(@RequestParam final String firstName, @RequestParam final String lastName, @RequestParam final GENDER gender) {
        System.out.println("create " + firstName + " " + lastName + " " + gender.toString());
        return userFacadeLayer.create(
                transformer.convertFrom(build(firstName, lastName, gender))
        );
    }

    //@RequestMapping(value = "/users/1", method = PUT)
    public boolean update(@RequestParam final String firstName, @RequestParam final String lastName, @RequestParam final GENDER gender) {
        System.out.println("create " + firstName + " " + lastName + " " + gender.toString());
        return userFacadeLayer.update(
                transformer.convertFrom(
                        build(firstName, lastName, gender)
                )
        );
    }

    //@RequestMapping(value = "/users/1", method = DELETE)
    public void delete(@RequestParam final long id) {
        System.out.println("delete " + id);
        userFacadeLayer.remove(id);
    }
}
