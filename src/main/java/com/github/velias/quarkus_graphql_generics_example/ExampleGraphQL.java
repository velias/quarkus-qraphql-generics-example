/*
 * JBoss, Home of Professional Open Source
 * Copyright 2020 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 */
package com.github.velias.quarkus_graphql_generics_example;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

/**
 * Example GraphQL API
 *
 * @author Vlastimil Elias (velias at redhat dot com)
 */
@GraphQLApi
@ApplicationScoped
public class ExampleGraphQL {

    @Query
    public String getString() {
        return null;
    }

    @Query
    public PagedResultConnectionResolvedToString getPagedResultResolvedToString() {
        return null;
    }

    @Query
    public PagedResultConnection<String> getPagedResultString() {
        return null;
    }

    @Query
    public PagedResultConnection<Person> getPagedResultPerson() {
        return null;
    }

}
