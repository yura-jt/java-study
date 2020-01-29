package com.bank.repository;

import java.util.Objects;

public class Page {
    private final int pageNumber;
    private final int itemsPerPage;

    public Page(int pageNumber, int itemsPerPage) {
        this.pageNumber = pageNumber;
        this.itemsPerPage = itemsPerPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }
}