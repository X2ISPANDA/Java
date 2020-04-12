package com.ychs.pojo;


public class Page {
    private int page;//当前页
    private int limit=10;//每页条数

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
