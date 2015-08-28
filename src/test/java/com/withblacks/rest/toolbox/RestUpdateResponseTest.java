package com.withblacks.rest.toolbox;

import com.withblacks.facade.EntityDto;
import com.withblacks.facade.EntityFacade;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

import static com.withblacks.business.entities.user.GENDER.MALE;
import static com.withblacks.business.layers.user.UserMockHelper.mockUserDto;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

public class RestUpdateResponseTest {

    private RestUpdateResponse response;
    private EntityFacade facade;
    private EntityDto dto;

    @Before
    public void setup() {
        dto = mockUserDto("Iron", "Man", MALE);
        facade = mock(EntityFacade.class);
        response = new RestUpdateResponse(facade);
    }

    @Test
    public void itShouldReturnStatusOK() throws Exception {
        doReturn(new ResponseEntity<>(OK)).when(facade).update(1L, dto);
        assertThat(response.getResponseEntity(1L, dto).getStatusCode(), is(OK));
    }

    @Test
    public void itShouldReturnStatusNOT_FOUNDWhenNoSuchElementException() throws Exception {
        doThrow(new NoSuchElementException()).when(facade).update(1L, dto);
        assertThat(response.getResponseEntity(1L, dto).getStatusCode(), is(NOT_FOUND));
    }

    @Test
    public void itShouldReturnStatusNOT_FOUNDWhenClassCastException() throws Exception {
        doThrow(new ClassCastException()).when(facade).update(1L, dto);
        assertThat(response.getResponseEntity(1L, dto).getStatusCode(), is(NOT_ACCEPTABLE));
    }

    @Test
    public void itShouldReturnStatusBAD_REQUESTWhenIllegalArgumentException() throws Exception {
        doThrow(new IllegalArgumentException()).when(facade).update(1L, dto);
        assertThat(response.getResponseEntity(1L, dto).getStatusCode(), is(BAD_REQUEST));
    }
}