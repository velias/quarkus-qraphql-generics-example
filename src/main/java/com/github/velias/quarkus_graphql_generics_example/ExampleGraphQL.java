/*
 * JBoss, Home of Professional Open Source
 * Copyright 2020 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 */
package com.github.velias.quarkus_graphql_generics_example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.GraphQLException;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import com.github.velias.quarkus_graphql_generics_example.pager.PageInfo;
import com.github.velias.quarkus_graphql_generics_example.pager.PagedResultConnection;
import com.github.velias.quarkus_graphql_generics_example.pager.PagerUtils;

/**
 * Example GraphQL API
 *
 * @author Vlastimil Elias (velias at redhat dot com)
 */
@GraphQLApi
@ApplicationScoped
public class ExampleGraphQL {

    private static final String PAGERPARAM_NAME_AFTER = "after";

    private static final String PAGERPARAM_NAME_FIRST = "first";

    private static final String PAGERPARAM_DESC_AFTER = "Cursor of solution to return results after - pager";

    private static final String PAGERPARAM_DESC_FIRST = "Max number of returned records, default value is 20, max value is 50 - pager";

    @Query
    public String getString() {
        return null;
    }

    private static final int MAX_INDEX = 999; 
    
    @Query
    public PagedResultConnectionResolvedToString getPagedResultResolvedToString(@Name(PAGERPARAM_NAME_FIRST) @Description(PAGERPARAM_DESC_FIRST) Integer first, @Name(PAGERPARAM_NAME_AFTER) @Description(PAGERPARAM_DESC_AFTER) String after)
            throws GraphQLException {
        int startIndex = PagerUtils.getStartIndex(after);
        int lastIndex = PagerUtils.getLastIndex(first, startIndex, 20, 50);
        
        if(lastIndex > MAX_INDEX)
            lastIndex = MAX_INDEX;

        List<String> r = new ArrayList<>();
        for (int i = startIndex; i<= lastIndex; i++) {
            r.add("Item " + i);
        }

        PagedResultConnectionResolvedToString ret = new PagedResultConnectionResolvedToString();
        ret.addEdges(r, startIndex);

        ret.setPageInfo(new PageInfo(startIndex, first, MAX_INDEX+1));

        return ret;
    }

    @Query
    public PagedResultConnection<String> getPagedResultString(@Name(PAGERPARAM_NAME_FIRST) @Description(PAGERPARAM_DESC_FIRST) Integer first, @Name(PAGERPARAM_NAME_AFTER) @Description(PAGERPARAM_DESC_AFTER) String after) throws GraphQLException {
      int startIndex = PagerUtils.getStartIndex(after);
      int lastIndex = PagerUtils.getLastIndex(first, startIndex, 20, 50);
      
      if(lastIndex > MAX_INDEX)
          lastIndex = MAX_INDEX;

      List<String> r = new ArrayList<>();
      for (int i = startIndex; i<= lastIndex; i++) {
          r.add("Item " + i);
      }

      PagedResultConnection<String> ret = new PagedResultConnection<String>();
      ret.addEdges(r, startIndex);

      ret.setPageInfo(new PageInfo(startIndex, first, MAX_INDEX+1));

      return ret;
       
    }
    
    @Query
    public PagedResultConnection<Integer> getPagedResultInt(@Name(PAGERPARAM_NAME_FIRST) @Description(PAGERPARAM_DESC_FIRST) Integer first, @Name(PAGERPARAM_NAME_AFTER) @Description(PAGERPARAM_DESC_AFTER) String after) throws GraphQLException {
        int startIndex = PagerUtils.getStartIndex(after);
        int lastIndex = PagerUtils.getLastIndex(first, startIndex, 20, 50);
        
        if(lastIndex > MAX_INDEX)
            lastIndex = MAX_INDEX;

        List<Integer> r = new ArrayList<>();
        for (int i = startIndex; i<= lastIndex; i++) {
            r.add(i);
        }

        PagedResultConnection<Integer> ret = new PagedResultConnection<>();
        ret.addEdges(r, startIndex);

        ret.setPageInfo(new PageInfo(startIndex, first, MAX_INDEX+1));

        return ret;
        
    }

    @Query
    public PagedResultConnection<Integer> getPagedResultResolvedToInt(@Name(PAGERPARAM_NAME_FIRST) @Description(PAGERPARAM_DESC_FIRST) Integer first, @Name(PAGERPARAM_NAME_AFTER) @Description(PAGERPARAM_DESC_AFTER) String after) throws GraphQLException {
        int startIndex = PagerUtils.getStartIndex(after);
        int lastIndex = PagerUtils.getLastIndex(first, startIndex, 20, 50);
        
        if(lastIndex > MAX_INDEX)
            lastIndex = MAX_INDEX;

        List<Integer> r = new ArrayList<>();
        for (int i = startIndex; i<= lastIndex; i++) {
            r.add(i);
        }

        PagedResultConnectionResolvedToInteger ret = new PagedResultConnectionResolvedToInteger();
        ret.addEdges(r, startIndex);

        ret.setPageInfo(new PageInfo(startIndex, first, MAX_INDEX+1));

        return ret;
        
    }

    @Query
    public PagedResultConnection<Person> getPagedResultResolvedToPerson(@Name(PAGERPARAM_NAME_FIRST) @Description(PAGERPARAM_DESC_FIRST) Integer first, @Name(PAGERPARAM_NAME_AFTER) @Description(PAGERPARAM_DESC_AFTER) String after) throws GraphQLException {
        int startIndex = PagerUtils.getStartIndex(after);
        int lastIndex = PagerUtils.getLastIndex(first, startIndex, 20, 50);
        
        if(lastIndex > MAX_INDEX)
            lastIndex = MAX_INDEX;

        List<Person> r = new ArrayList<>();
        for (int i = startIndex; i<= lastIndex; i++) {
            r.add(new Person("John " + i, "Doe", new Date(i*12545L)));
        }

        PagedResultConnectionResolvedToPerson ret = new PagedResultConnectionResolvedToPerson();
        ret.addEdges(r, startIndex);

        ret.setPageInfo(new PageInfo(startIndex, first, MAX_INDEX+1));

        return ret;
    }
    
    @Query
    public PagedResultConnection<Person> getPagedResultPerson(@Name(PAGERPARAM_NAME_FIRST) @Description(PAGERPARAM_DESC_FIRST) Integer first, @Name(PAGERPARAM_NAME_AFTER) @Description(PAGERPARAM_DESC_AFTER) String after) throws GraphQLException {
        int startIndex = PagerUtils.getStartIndex(after);
        int lastIndex = PagerUtils.getLastIndex(first, startIndex, 20, 50);
        
        if(lastIndex > MAX_INDEX)
            lastIndex = MAX_INDEX;

        List<Person> r = new ArrayList<>();
        for (int i = startIndex; i<= lastIndex; i++) {
            r.add(new Person("John " + i, "Doe", new Date(i*12545L)));
        }

        PagedResultConnection<Person> ret = new PagedResultConnection<>();
        ret.addEdges(r, startIndex);

        ret.setPageInfo(new PageInfo(startIndex, first, MAX_INDEX+1));

        return ret;
    }

}
