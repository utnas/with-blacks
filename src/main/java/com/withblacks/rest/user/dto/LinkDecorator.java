package com.withblacks.rest.user.dto;

import com.withblacks.rest.user.UserRestImpl;

import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class LinkDecorator {

    public static Iterable<UserResource> addLinks(final Iterable<UserResource> resources, final Optional<Class<UserRestImpl>> classOptional) {
        if (classOptional.isPresent()) {
            for (UserResource resource : resources) {
                resource.add(linkTo(classOptional.get()).slash(resource.getIds()).withSelfRel());
            }
        }
        return resources;
    }

    public static UserResource addLinks(final UserResource resource, final Optional<Class<UserRestImpl>> classOptional) {
        if (classOptional.isPresent()) {
            resource.add(linkTo(classOptional.get()).slash(resource.getIds()).withSelfRel());
        }
        return resource;
    }
}
