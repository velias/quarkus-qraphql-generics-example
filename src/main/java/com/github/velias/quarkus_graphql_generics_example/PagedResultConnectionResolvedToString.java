/*
 * JBoss, Home of Professional Open Source
 * Copyright 2020 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 */
package com.github.velias.quarkus_graphql_generics_example;

import org.eclipse.microprofile.graphql.Description;

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
public class PagedResultConnectionResolvedToString extends PagedResultConnection<String> {

}
