/*
 * JBoss, Home of Professional Open Source
 * Copyright 2020 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 */
package com.github.velias.quarkus_graphql_generics_example;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

import io.smallrye.graphql.schema.model.Operation;

/**
 * Class to examine Events fired by the GraphQL framework
 *
 * @author Vlastimil Elias (velias at redhat dot com)
 */
@ApplicationScoped
public class EventLogger {
    
    private static final Logger LOG = Logger.getLogger(EventLogger.class);
    
    public void processOperationEvent(@Observes Operation event) {
        LOG.error(event);
    }

    

}
