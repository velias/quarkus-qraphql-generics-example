/*
 * JBoss, Home of Professional Open Source
 * Copyright 2020 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 */
package com.github.velias.quarkus_graphql_generics_example;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.NonNull;

/**
 * Result returned from GrapgQL method which supports pagers as defined in:
 * <ul>
 * <li><a href="https://graphql.org/learn/pagination/">https://graphql.org/learn/pagination/</a>
 * <li><a href="https://relay.dev/graphql/connections.htm">https://relay.dev/graphql/connections.htm</a>
 * </ul>
 * 
 * @author Vlastimil Elias (velias at redhat dot com)
 */
@Description("Pager response as defined in https://relay.dev/graphql/connections.htm")
public class PagedResultConnection<V> {

    @NonNull
    protected List<IPagedResultEdge<V>> edges = new ArrayList<>();
    
    @NonNull
    protected PageInfo pageInfo;

    public List<IPagedResultEdge<V>> getEdges() {
        return edges;
    }

    public void setEdges(List<IPagedResultEdge<V>> edges) {
        this.edges = edges;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public void addEdges(List<V> nodes, int startIndex) {
        if (nodes != null) {
            for (int i = 0; i < nodes.size(); i++) {
                edges.add(new PagedResultEdge<V>(nodes.get(i), startIndex + i));
            }
        }
    }

    @Override
    public String toString() {
        return "PagedResultConnection [pageInfo=" + pageInfo + ", edges=" + edges + "]";
    }

}
