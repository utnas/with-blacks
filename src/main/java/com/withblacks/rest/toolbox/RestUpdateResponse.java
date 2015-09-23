package com.withblacks.rest.toolbox;

import com.withblacks.facade.EntityDto;
import com.withblacks.facade.EntityFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

@Component
class RestUpdateResponse {

    private EntityFacade facade;

    public RestUpdateResponse() {
    }

    public RestUpdateResponse(final EntityFacade facade) {
        this.facade = facade;
    }

    public ResponseEntity<?> getResponseEntity(final Long id, final EntityDto resource) {
        try {
            return new ResponseEntity<>(facade.update(id, resource), OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        } catch (ClassCastException e) {
            return new ResponseEntity(NOT_ACCEPTABLE);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(BAD_REQUEST);
        }
    }
}
