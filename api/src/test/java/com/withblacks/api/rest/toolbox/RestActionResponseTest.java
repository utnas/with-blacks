package com.withblacks.api.rest.toolbox;

import com.withblacks.api.business.entities.user.GENDER;
import com.withblacks.api.facade.user.dto.UserDto;
import com.withblacks.api.business.layers.user.UserMockHelper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.http.HttpStatus.OK;

public class RestActionResponseTest {
    private RestActionResponse actionResponse;
    private UserDto dto;

    @Before
    public void setUp() {
        dto = UserMockHelper.mockUserDto("Iron", "Man", GENDER.MALE);

        RestUpdateResponse updateResponse = mock(RestUpdateResponse.class);
        doReturn(new ResponseEntity(OK)).when(updateResponse).getResponseEntity(1L, dto);

        RestRemoveResponse removeResponse = mock(RestRemoveResponse.class);
        doReturn(new ResponseEntity(OK)).when(removeResponse).getResponseEntity(1L);

        actionResponse = new RestActionResponse(updateResponse, removeResponse);
    }

    @Test
    public void testUpdateEntity() throws Exception {
        assertThat(actionResponse.updateEntity(1L, dto).getStatusCode(), is(OK));
    }

    @Test
    public void testDeleteEntity() throws Exception {
        assertThat(actionResponse.deleteEntity(1L).getStatusCode(), is(OK));
    }
}