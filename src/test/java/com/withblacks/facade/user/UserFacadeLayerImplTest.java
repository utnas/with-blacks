package com.withblacks.facade.user;

import com.withblacks.business.builder.UserBuilder;
import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import com.withblacks.business.layers.UserLayer;
import com.withblacks.rest.user.dto.UserResource;
import com.withblacks.rest.user.dto.mapper.UserMapperImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

import static com.google.common.collect.Iterables.size;
import static com.withblacks.rest.user.dto.mapper.UserResourceBuilder.build;
import static com.withblacks.rest.user.utils.MatcherUtils.resourceHasProperties;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.doReturn;

public class UserFacadeLayerImplTest {

    private UserFacadeLayerImpl userFacadeLayer;
    private UserResource firstUserResource;
    private UserResource secondUserResource;

    @Before
    public void setUp() throws Exception {
        final UserLayer userLayer = Mockito.mock(UserLayer.class);
        final UserMapperImpl mapper = Mockito.mock(UserMapperImpl.class);

        firstUserResource = build(1L, "FirstName", "LastName", GENDER.FEMALE);
        secondUserResource = build(1L, "FirstName1", "LastName1", GENDER.MALE);

        doReturn(asList(firstUserResource, secondUserResource)).when(mapper).convertTo(anyList());
        doReturn(firstUserResource).when(mapper).convertTo(any(User.class));
        doReturn(UserBuilder.build(1L, "FirstName", "LastName", GENDER.MALE)).when(mapper).convertFrom(any(UserResource.class));

        userFacadeLayer = new UserFacadeLayerImpl(userLayer, mapper);
    }

    @Test
    public void testGetUserByName() throws Exception {
        assertThat(userFacadeLayer.getUser("FirstName"), resourceHasProperties(1L, "FirstName", "LastName", GENDER.FEMALE));
    }

    @Test
    public void testGetUsers() throws Exception {
        assertThat(size(userFacadeLayer.getUsers()), is(2));
    }

    @Test
    public void testGetUserById() throws Exception {
        assertThat(userFacadeLayer.getUser(1L), resourceHasProperties(1L, "FirstName", "LastName", GENDER.FEMALE));
    }

    @Test
    public void testCreate() throws Exception {
        assertThat(userFacadeLayer.create(firstUserResource), resourceHasProperties(1L, "FirstName", "LastName", GENDER.FEMALE));
    }

    @Test
    public void testUpdate() throws Exception {
        userFacadeLayer.create(firstUserResource);
        assertThat(userFacadeLayer.update(1L, secondUserResource), is(false));
    }

    @Test
    public void testRemove() throws Exception {
        userFacadeLayer.create(firstUserResource);
        userFacadeLayer.remove(1L);
        try {
            userFacadeLayer.getUser(1L);
        } catch (Exception e) {
            assertThat(e instanceof NoSuchElementException, is(true));
        }
    }
}