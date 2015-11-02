package com.withblacks.api.rest.user;

import com.withblacks.api.business.entities.user.GENDER;
import com.withblacks.api.facade.user.dto.UserDto;
import com.withblacks.api.rest.UserRest;
import com.withblacks.api.facade.user.UserFacadeImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static com.withblacks.api.business.layers.user.UserMockHelper.mockUserDto;
import static com.withblacks.api.rest.utils.ActionResponseUtil.mockActionResponse;
import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class UserRestTest {

    private UserRest rest;
    private UserFacadeImpl facade;
    private UserDto dto;

    @Before
    public void setUp() throws Exception {
        facade = mock(UserFacadeImpl.class);
        dto = mockUserDto("Iron", "Man", GENDER.MALE);
        rest = new UserRest(facade, mockActionResponse(new ResponseEntity<>(OK)));
    }

    @Test
    public void testFindAll() throws Exception {
        doReturn(singletonList(dto)).when(facade).getAll();
        assertThat(rest.findAll().getStatusCode(), is(OK));
    }

    @Test
    public void testFindById() throws Exception {
        doReturn(dto).when(facade).getOne(anyLong());
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