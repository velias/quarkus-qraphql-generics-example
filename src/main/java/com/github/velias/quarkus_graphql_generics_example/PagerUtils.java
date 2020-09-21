/*
 * JBoss, Home of Professional Open Source
 * Copyright 2020 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 */
package com.github.velias.quarkus_graphql_generics_example;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.eclipse.microprofile.graphql.GraphQLException;
import org.jboss.logging.Logger;

/**
 * Utility classes for implementation of pager pattern in GraphQL api.
 *
 * @author Vlastimil Elias (velias at redhat dot com)
 */
public class PagerUtils {

    private static final Logger LOGGER = Logger.getLogger(PagerUtils.class.getName());

    /**
     * Encode index into the opaque cursor String.
     * 
     * @param index to encode
     * @return encoded cursor value
     */
    public static String cursorEncode(int index) {
        return Base64.getEncoder().encodeToString(Integer.toString(index).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Encode index into the opaque cursor String.
     * 
     * @param index to encode
     * @return encoded cursor value
     */
    public static String cursorEncode(long index) {
        return Base64.getEncoder().encodeToString(Long.toString(index).getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Decode opaque cursor string into index.
     * 
     * @param cursor to decode, null safe
     * @return decoded index or null if cursor was null
     * @throws GraphQLException if cursor is invalid, has invalid internal format ()
     */
    public static Integer cursorDecode(String cursor) throws GraphQLException {
        if (cursor == null)
            return null;

        try {
            Integer i = Integer.decode(new String(Base64.getDecoder().decode(cursor), (StandardCharsets.UTF_8)));
            if (i >= 0)
                return i;
            else
                LOGGER.debugf("Cursor '%s' is invalid due to: Negative integer value", cursor);

        } catch (IllegalArgumentException e) {
            LOGGER.debugf("Cursor '%s' is invalid due to: %s", cursor, e.getMessage());
        }
        throw new GraphQLException("Cursor '" + cursor + "' is invalid");
    }

    /**
     * Validate 'first' argument used in GraphQL queries with pagination. It have to be greater than 0 if provided.
     * 
     * @param reqParamFirst parameter value to be validated
     * @param maxFirst maximal value accepted in <code>reqParamFirst</code>, error if value is higher
     * 
     * @throws GraphQLException if value is invalid
     */
    public static void validateParamFirst(Integer reqParamFirst, int maxFirst) throws GraphQLException {
        if (reqParamFirst != null) {
            if (reqParamFirst <= 0)
                throw new GraphQLException("Argument 'first' must be greater than 0");
            if (reqParamFirst.intValue() > maxFirst) {
                throw new GraphQLException("Value too high for 'first' param, max value is " + maxFirst);
            }
        }
    }

    /**
     * Get start index for data loading based on value of the <code>after</code> cursor taken from request.
     * 
     * @param reqParamAfter after cursor, can be null
     * @return start index to get data for response
     * @throws GraphQLException if cursor is invalid
     */
    public static int getStartIndex(String reqParamAfter) throws GraphQLException {
        if (reqParamAfter != null) {
            return PagerUtils.cursorDecode(reqParamAfter) + 1;
        }
        return 0;
    }

    /**
     * Get last index for data loading based on value of the <code>first</code> value from request and start index.
     * 
     * @param reqParamFirst to use, can be null
     * @param startIndex
     * @param defaultFirst default value used if <code>reqParamFirst</code> is null.
     * @param maxFirst maximal value accepted in <code>reqParamFirst</code>, error if value is higher
     * @return last index which can be used to get data for response
     * @throws GraphQLException
     */
    public static int getLastIndex(Integer reqParamFirst, int startIndex, int defaultFirst, int maxFirst) throws GraphQLException {
        int f = defaultFirst;
        if (reqParamFirst != null) {
            validateParamFirst(reqParamFirst, maxFirst);
            f = reqParamFirst.intValue();
        }
        return startIndex + f - 1;
    }

}
