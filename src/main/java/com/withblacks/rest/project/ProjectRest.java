package com.withblacks.rest.project;

import com.withblacks.facade.project.ProjectFacade;
import com.withblacks.facade.project.dto.ProjectDto;
import com.withblacks.rest.RestLayer;
import com.withblacks.rest.toolbox.RestResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:application.properties")
@RequestMapping(value = "{@Value(\"${spring.rest.version}\")}/projects")
public class ProjectRest extends RestResponseUtil implements RestLayer<ProjectDto> {

    private ProjectFacade facade;
    @Value("${spring.rest.version}")
    private String API_REVISION;

    public ProjectRest() {
    }

    @Autowired
    public ProjectRest(final ProjectFacade facade) {
        this.facade = facade;
    }

    @Override
    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        try {
            return new ResponseEntity<>(facade.getAll(), OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        try {
            return new ResponseEntity<>(facade.getOne(id), OK);
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
    @RequestMapping(value = "/{id}", method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") final Long id, @RequestBody final ProjectDto resource) {
        return getResponseEntity(facade, id, resource);
    }

    @RequestMapping(value = "/{id}", method = PATCH, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patch(@PathVariable("id") final Long id, @RequestBody final ProjectDto resource) {
        return getResponseEntity(facade, id, resource);
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        return getResponseEntity(facade, id);
    }
}
