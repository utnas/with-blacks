package com.withblacks.facade.user;

import com.withblacks.business.entities.user.User;
import com.withblacks.business.layers.user.UserLayer;
import com.withblacks.business.layers.user.UserLayerImpl;
import com.withblacks.facade.user.dto.UserDto;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static com.google.common.collect.Iterables.size;
import static com.withblacks.business.entities.user.GENDER.MALE;
import static com.withblacks.business.layers.user.UserMockHelper.*;
import static com.withblacks.rest.utils.MatcherUtils.dtoHasProperties;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class UserFacadeImplTest {

    private UserFacadeImpl userFacadeLayer;
    private UserLayer<User> layer;
    private User user;
    private UserDto dto;

    @Before
    public void setUp() throws Exception {
        user = mockUser("Iron", "Man", MALE);
        dto = mockUserDto("Iron", "Man", MALE);

        layer = mock(UserLayerImpl.class);
        userFacadeLayer = new UserFacadeImpl(layer, mockUserMapper(dto, user));
    }

    @Test
    public void testGetUserByName() throws Exception {
        doReturn(user).when(layer).find(anyString());

        assertThat(userFacadeLayer.getOne("Iron"), dtoHasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testGetUsers() throws Exception {
        doReturn(singletonList(user)).when(layer).findAll();
        assertThat(size(userFacadeLayer.getAll()), is(1));
    }

    @Test
    public void testGetUserById() throws Exception {
        when(layer.find(anyLong())).thenReturn(user);

        assertThat(userFacadeLayer.getOne(1L), dtoHasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testCreate() throws Exception {
        doReturn(user).when(layer).create(any(User.class));

        assertThat(userFacadeLayer.create(dto), dtoHasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testUpdate() throws Exception {
        doReturn(user).when(layer).update(anyLong(), any(User.class));

        assertThat(userFacadeLayer.update(1L, dto), dtoHasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testRemove() throws Exception {
        doReturn(user).when(layer).create(any(User.class));

        userFacadeLayer.create(dto);
        userFacadeLayer.remove(1L);
        try {
            userFacadeLayer.getOne(1L);
        } catch (Exception e) {
            assertThat(e instanceof NoSuchElementException, is(true));
        }
    }

}
