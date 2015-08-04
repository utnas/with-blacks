package com.withblacks.facade.user;

import com.withblacks.business.entities.User;
import com.withblacks.business.layers.user.UserLayer;
import com.withblacks.business.layers.user.UserLayerImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static com.google.common.collect.Iterables.size;
import static com.withblacks.business.entities.GENDER.MALE;
import static com.withblacks.business.layers.user.UserMockHelper.mockUser;
import static com.withblacks.rest.user.utils.MatcherUtils.hasProperties;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class UserFacadeLayerImplTest {

    private UserFacadeLayerImpl userFacadeLayer;
    private UserLayer layer;
    private User user;

    @Before
    public void setUp() throws Exception {
        layer = mock(UserLayerImpl.class);
        userFacadeLayer = new UserFacadeLayerImpl(layer);
        user = mockUser("Iron", "Man", MALE);
    }

    @Test
    public void testGetUserByName() throws Exception {
        doReturn(user).when(layer).find(anyString());

        assertThat(userFacadeLayer.getUser("Iron"), hasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testGetUsers() throws Exception {
        doReturn(asList(user)).when(layer).findAll();
        assertThat(size(userFacadeLayer.getUsers()), is(1));
    }

    @Test
    public void testGetUserById() throws Exception {
        doReturn(user).when(layer).find(anyLong());

        assertThat(userFacadeLayer.getUser(1L), hasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testCreate() throws Exception {
        doReturn(user).when(layer).create(any(User.class));

        assertThat(userFacadeLayer.create(user), hasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testUpdate() throws Exception {
        doReturn(user).when(layer).update(anyLong(), any(User.class));

        assertThat(userFacadeLayer.update(1L, user), hasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testRemove() throws Exception {
        doReturn(user).when(layer).create(any(User.class));

        userFacadeLayer.create(user);
        userFacadeLayer.remove(1L);
        try {
            userFacadeLayer.getUser(1L);
        } catch (Exception e) {
            assertThat(e instanceof NoSuchElementException, is(true));
        }
    }

}
