package com.withblacks.rest.project;

import com.withblacks.facade.project.ProjectFacadeLayer;
import com.withblacks.facade.project.dto.ProjectDto;
import com.withblacks.rest.RestLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "{@Value(\"${spring.rest.version}\")}/projects")
public class ProjectRest implements RestLayer<ProjectDto> {

    private ProjectFacadeLayer facade;
    @Value("${spring.rest.version}")
    private String apiRevision;

    public ProjectRest() {
    }

    @Autowired
    public ProjectRest(final ProjectFacadeLayer facade) {
        this.facade = facade;
    }

    @Override
    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(facade.getProjects(), OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    @RequestMapping(value = "{apiRevision}/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        try {
            return new ResponseEntity<>(facade.getProject(id), OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @Override
    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody final ProjectDto resource) {
        try {
            return new ResponseEntity<>(facade.create(resource), OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(CONFLICT);
        }
    }

    @Override
    @RequestMapping(value = "{apiRevision}/{id}", method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") final Long id, @RequestBody final ProjectDto resource) {
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

    @Override
    @RequestMapping(value = "{apiRevision}/{id}", method = DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
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
