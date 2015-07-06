package com.withblacks.rest;

public interface LinkDecorator<T> {

    public Iterable<T> addLinks(final Iterable<T> resources);

    public T addLink(final T resource);
}