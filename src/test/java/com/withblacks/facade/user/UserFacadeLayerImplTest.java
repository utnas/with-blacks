package com.withblacks.facade.user;

import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import com.withblacks.business.layers.UserLayer;
import com.withblacks.business.layers.UserLayerImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.codehaus.groovy.runtime.InvokerHelper.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class UserFacadeLayerImplTest {

    private UserFacadeLayerImpl userFacadeLayer;
    private UserLayer userLayer;
    private List<User> users;

    @Before
    public void setUp() throws Exception {
        userLayer = mock(UserLayerImpl.class);
        users = asList(mockUsers("Bran", "Arthur", GENDER.FEMALE));
        userFacadeLayer = new UserFacadeLayerImpl(userLayer);

        doReturn(users).when(userLayer).findAll();
    }

    @Test
    public void testGetUserByName() throws Exception {
        //assertThat(userFacadeLayer.getUser("FirstName"), resourceHasProperties(1L, "FirstName", "LastName", GENDER.FEMALE));
    }

    @Test
    public void testGetUsers() throws Exception {
        //assertThat(size(userFacadeLayer.getUsers()), is(1));
    }

    @Test
    public void testGetUserById() throws Exception {
        //assertThat(userFacadeLayer.getUser(1L), resourceHasProperties(1L, "FirstName", "LastName", GENDER.FEMALE));
    }

    @Test
    public void testCreate() throws Exception {
        //assertThat(userFacadeLayer.create(getLast(users)), resourceHasProperties(1L, "FirstName", "LastName", GENDER.FEMALE));
    }

    @Test
    public void testUpdate() throws Exception {
        //userFacadeLayer.create(firstUserResource);
    }

    @Test
    public void testRemove() throws Exception {
        // userFacadeLayer.create(us);
        userFacadeLayer.remove(1L);
        try {
            userFacadeLayer.getUser(1L);
        } catch (Exception e) {
            assertThat(e instanceof NoSuchElementException, is(true));
        }
    }

    private User mockUsers(final String firstName, final String lastName, final GENDER gender) {
        final User user = mock(User.class);

        doReturn(firstName).when(user).getFirstName();
        doReturn(lastName).when(user).getLastName();
        doReturn(gender).when(user).getGender();

        return user;
    }
}
