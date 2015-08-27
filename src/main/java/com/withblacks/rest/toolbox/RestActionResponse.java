package com.withblacks.rest.toolbox;

import com.withblacks.facade.EntityDto;
import com.withblacks.facade.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestActionResponse {

    private UserFacade facade;
    private RestUpdateResponse restUpdateResponse;
    private RestRemoveResponse restRemoveResponse;

    @Autowired
    public RestActionResponse(final UserFacade facade, final RestUpdateResponse restUpdateResponse, final RestRemoveResponse restRemoveResponse) {
        this.facade = facade;
        this.restUpdateResponse = restUpdateResponse;
        this.restRemoveResponse = restRemoveResponse;
    }

    public ResponseEntity<?> updateEntity(final Long id, final EntityDto resource) {
        return restUpdateResponse.getResponseEntity(id, resource);
    }

    public ResponseEntity<?> deleteEntity(final Long id) {
        return restRemoveResponse.getResponseEntity(id);
    }
}
