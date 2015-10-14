package com.withblacks.api.rest.toolbox;

import com.withblacks.api.facade.EntityFacade;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

public class RestRemoveResponseTest {

    private RestRemoveResponse response;
    private EntityFacade facade;

    @Before
    public void setup() {
        facade = mock(EntityFacade.class);
        response = new RestRemoveResponse(facade);
    }

    @Test
    public void itShouldReturnStatusOK() throws Exception {
        doNothing().when(facade).remove(1L);
        assertThat(response.getResponseEntity(1L).getStatusCode(), is(OK));
    }

    @Test
    public void itShouldReturnStatusNOT_FOUNDWhenNoSuchElementException() throws Exception {
        doThrow(new NoSuchElementException()).when(facade).remove(1L);
        assertThat(response.getResponseEntity(1L).getStatusCode(), is(NOT_FOUND));
    }

    @Test
    public void itShouldReturnStatusNOT_FOUNDWhenNullPointerException() throws Exception {
        doThrow(new NullPointerException()).when(facade).remove(1L);
        assertThat(response.getResponseEntity(1L).getStatusCode(), is(NOT_FOUND));
    }
}