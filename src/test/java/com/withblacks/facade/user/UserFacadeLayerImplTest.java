package com.withblacks.facade.user;

import com.withblacks.business.builder.UserBuilder;
import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import com.withblacks.business.layers.UserLayer;
import com.withblacks.facade.user.mapper.UserMapperImpl;
import com.withblacks.rest.user.dto.UserResource;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static com.google.common.collect.Iterables.size;
import static com.google.common.collect.Lists.newArrayList;
import static com.withblacks.facade.user.mapper.UserResourceBuilder.build;
import static com.withblacks.rest.user.utils.MatcherUtils.resourceHasProperties;
import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class UserFacadeLayerImplTest {

    private UserFacadeLayerImpl userFacadeLayer;
    private UserResource firstUserResource;
    private UserResource secondUserResource;

    @Before
    public void setUp() throws Exception {
        final UserLayer userLayer = mock(UserLayer.class);
        final UserMapperImpl mapper = mock(UserMapperImpl.class);

        User build1 = UserBuilder.build(1L, "FirstName", "LastName", GENDER.MALE);
        User build2 = UserBuilder.build(1L, "FirstName", "LastName", GENDER.MALE);

        firstUserResource = build(1L, "FirstName", "LastName", GENDER.FEMALE);
        secondUserResource = build(1L, "FirstName1", "LastName1", GENDER.MALE);

        doReturn(asList(firstUserResource, secondUserResource)).when(mapper).convertTo(anyList());
        doReturn(firstUserResource).when(mapper).convertTo(any(User.class));
        doReturn(build1).when(mapper).convertFrom(any(UserResource.class));

        userFacadeLayer = new UserFacadeLayerImpl(userLayer, mapper);
        doReturn(newArrayList(build1, build2)).when(userLayer).findAll();
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