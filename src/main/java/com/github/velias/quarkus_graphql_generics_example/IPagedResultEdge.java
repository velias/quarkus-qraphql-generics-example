package com.github.velias.quarkus_graphql_generics_example;

public interface IPagedResultEdge<V> {
    
    public V getNode();

    public String getCursor();

}
