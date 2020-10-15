/*
 * JBoss, Home of Professional Open Source
 * Copyright 2020 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 */
package com.github.velias.quarkus_graphql_generics_example.pager;

import org.eclipse.microprofile.graphql.NonNull;

/**
 * Page info used in {@link PagedResultConnection}.
 *
 * @author Vlastimil Elias (velias at redhat dot com)
 */
public class PageInfo {

    protected boolean hasPreviousPage;
    protected boolean hasNextPage;
    @NonNull
    protected String startCursor;
    @NonNull
    protected String endCursor;

    /**
     * @param startIndex of the data we return in this page
     * @param first request parameter used to load data
     * @param resultsetSize total size of all data we are paginating through (used to evaluate endCursor and hasNexttResult) 
     */
    public PageInfo(int startIndex, Integer first, long resultsetSize) {
        this.startCursor = PagerUtils.cursorEncode(startIndex);
        long endIndex = 0;
        if (first != null) {
            endIndex = startIndex + first - 1;
            if (endIndex + 1 > resultsetSize) {
                endIndex = resultsetSize - 1;
                this.hasNextPage = false;
            } else {
                this.hasNextPage = endIndex + 1 < resultsetSize;
            }
        } else {
            endIndex = resultsetSize - 1;
            this.hasNextPage = false;
        }
        if (endIndex < 0) {
            endIndex = 0;
        }
        this.endCursor = PagerUtils.cursorEncode(endIndex);
        this.hasPreviousPage = startIndex > 0;

    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public String getStartCursor() {
        return startCursor;
    }

    public void setStartCursor(String startCursor) {
        this.startCursor = startCursor;
    }

    public String getEndCursor() {
        return endCursor;
    }

    public void setEndCursor(String endCursor) {
        this.endCursor = endCursor;
    }

    @Override
    public String toString() {
        return "PageInfo [hasPreviousPage=" + hasPreviousPage + ", hasNextPage=" + hasNextPage + ", startCursor=" + startCursor + ", endCursor=" + endCursor + "]";
    }

}
