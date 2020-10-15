package com.github.velias.quarkus_graphql_generics_example.pager;

public interface IPagedResultEdge<V> {
    
    public V getNode();

    public String getCursor();

}
