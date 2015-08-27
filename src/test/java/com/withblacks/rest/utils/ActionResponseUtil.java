package com.withblacks.rest.utils;

import com.withblacks.facade.EntityDto;
import com.withblacks.rest.toolbox.RestActionResponse;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ActionResponseUtil {

    public static RestActionResponse mockActionResponse(final ResponseEntity<Object> response) {
        final RestActionResponse actionResponse = mock(RestActionResponse.class);
        doReturn(response).when(actionResponse).deleteEntity(anyLong());
        doReturn(response).when(actionResponse).updateEntity(anyLong(), Mockito.any(EntityDto.class));
        return actionResponse;
    }
}
