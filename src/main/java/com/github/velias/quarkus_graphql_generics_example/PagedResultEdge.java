/*
 * JBoss, Home of Professional Open Source
 * Copyright 2020 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 */
package com.github.velias.quarkus_graphql_generics_example;

import org.eclipse.microprofile.graphql.NonNull;

/**
 * Page edge entity used in {@link PagedResultConnection}. Contains cursor and node object itself.
 *
 * @author Vlastimil Elias (velias at redhat dot com)
 */
public class PagedResultEdge<T> implements IPagedResultEdge<T> {
    
    @NonNull
    protected T node;
    
    @NonNull
    protected String cursor;

    /**
     * @param node object itself
     * @param index of the entity in whole result set to generate cursor from.
     */
    public PagedResultEdge(T node, int index) {
        super();
        this.node = node;
        this.cursor = PagerUtils.cursorEncode(index);
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    @Override
    public String toString() {
        return "PagedResultEdge [node=" + node + ", cursor=" + cursor + "]";
    }

}
