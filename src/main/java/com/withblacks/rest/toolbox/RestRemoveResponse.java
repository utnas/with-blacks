package com.withblacks.rest.toolbox;

import com.withblacks.facade.EntityFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Component
public class RestRemoveResponse {
    private EntityFacade facade;

    public RestRemoveResponse() {
    }

    public RestRemoveResponse(final EntityFacade facade) {
        this.facade = facade;
    }

    public ResponseEntity<?> getResponseEntity(final Long id) {
        try {
            facade.remove(id);
            return new ResponseEntity(OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        } catch (NullPointerException e) {
            return new ResponseEntity(NOT_FOUND);
        }
    }
}
