package com.withblacks.rest.user.dto;

public interface LinkDecorator<T> {

    public Iterable<T> addLinks(final Iterable<T> resources);

    public T addLinks(final T resource);
}