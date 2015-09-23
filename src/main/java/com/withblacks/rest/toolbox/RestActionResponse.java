package com.withblacks.rest.toolbox;

import com.withblacks.facade.EntityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestActionResponse {

    private final RestUpdateResponse restUpdateResponse;
    private final RestRemoveResponse restRemoveResponse;

    @Autowired
    public RestActionResponse(final RestUpdateResponse restUpdateResponse, final RestRemoveResponse restRemoveResponse) {
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
