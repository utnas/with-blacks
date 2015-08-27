package com.withblacks.rest.toolbox;

import com.withblacks.facade.EntityDto;
import com.withblacks.facade.EntityFacade;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;

public class RestResponseUtil {
    public static ResponseEntity<?> getResponseEntity(EntityFacade facade, Long id, EntityDto resource) {
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

    public static ResponseEntity<?> getResponseEntity(final EntityFacade facade, Long id) {
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
