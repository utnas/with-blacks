package com.withblacks.business.layers;

import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import com.withblacks.repository.user.UserRepositoryLayer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.google.common.collect.Lists.newArrayList;
import static com.withblacks.business.builder.UserBuilder.build;
import static com.withblacks.rest.user.utils.MatcherUtils.hasProperties;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;

public class UserLayerImplTest {

    private UserRepositoryLayer repositoryLayer;
    private UserLayerImpl userLayer;

    @Before
    public void setUp() throws Exception {
        repositoryLayer = Mockito.mock(UserRepositoryLayer.class);
        userLayer = new UserLayerImpl(repositoryLayer);
    }

    @Test
    public void testItShouldFindUsetById() throws Exception {
        doReturn(build(1, "FirstName", "LastName", GENDER.FEMALE)).when(repositoryLayer).find(1L);

        assertThat(userLayer.find(1L), hasProperties(1L, "FirstName", "LastName", GENDER.FEMALE));
    }

    @Test
    public void testItShouldFindAllUsers() throws Exception {
        doReturn(newArrayList(
                build(1, "FirstName", "LastName", GENDER.FEMALE),
                build(2, "FirstName1", "LastName1", GENDER.MALE)))
                .when(repositoryLayer).findAll();

        assertThat(userLayer.findAll().get(1), hasProperties(2L, "FirstName1", "LastName1", GENDER.MALE));
    }

    @Test
    public void testItShouldCreateUser() throws Exception {
        final User mock = build(1L, "FirstName", "LastName", GENDER.FEMALE);
        doReturn(mock).when(repositoryLayer).save(any());

        assertThat(userLayer.create(mock), hasProperties(1L, "FirstName", "LastName", GENDER.FEMALE));
    }

    @Test
    public void testItShouldUpdateUser() throws Exception {
        final User mock = build(1L, "FirstName", "LastName", GENDER.FEMALE);
        doReturn(true).when(repositoryLayer).modify(any(), any());

        assertThat(userLayer.update(1L, mock), is(true));
    }

    @Test
    public void testItShouldDeleteUser() throws Exception {
        userLayer.delete(1L);
        assertNull(userLayer.find(1L));
    }

    @Test
    public void testItShouldFindUserByName() throws Exception {
        doReturn(build(1, "FirstName", "LastName", GENDER.FEMALE)).when(repositoryLayer).find("FirstName");

        assertThat(userLayer.find("FirstName"), hasProperties(1L, "FirstName", "LastName", GENDER.FEMALE));
    }
}