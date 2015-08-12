package com.withblacks.rest.user;

import com.withblacks.facade.user.UserFacade;
import com.withblacks.facade.user.dto.UserDto;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static com.withblacks.business.entities.user.GENDER.MALE;
import static com.withblacks.business.layers.user.UserMockHelper.mockUserDto;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class UserRestTest {

    private UserRest rest;
    private UserFacade facade;
    private UserDto dto;

    @Before
    public void setUp() throws Exception {
        facade = mock(UserFacade.class);
        dto = mockUserDto("Iron", "Man", MALE);
        rest = new UserRest(facade);
    }

    @Test
    public void testFindAll() throws Exception {
        doReturn(asList(dto)).when(facade).getUsers();
        assertThat(rest.findAll().getStatusCode(), is(OK));
    }

    @Test
    public void testFindById() throws Exception {
        doReturn(dto).when(facade).getUser(anyLong());
        assertThat(rest.findById(1L).getStatusCode(), is(OK));
    }

    @Test
    public void testCreate() throws Exception {
        doReturn(dto).when(facade).create(dto);
        assertThat(rest.create(dto).getStatusCode(), is(CREATED));
    }

    @Test
    public void testPatch() throws Exception {
        doReturn(dto).when(facade).update(1L, dto);
        assertThat(rest.patch(1L, dto).getStatusCode(), is(OK));
    }

    @Test
    public void testUpdate() throws Exception {
        doReturn(dto).when(facade).update(1L, dto);
        assertThat(rest.update(1L, dto).getStatusCode(), is(OK));
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(facade).remove(1L);
        assertThat(rest.delete(1L).getStatusCode(), is(OK));
    }
}