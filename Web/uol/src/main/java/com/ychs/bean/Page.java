/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.bean;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/22 14:11
 */
public class Page<T> {
    //当前页面
    private int curPage;
    //共多少页
    private int totalPage;
    //共多少条
    private int totalCount;
    //每页多少条
    private int everyCount = 2;

    private List<T> list;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getEveryCount() {
        return everyCount;
    }

    public void setEveryCount(int everyCount) {
        this.everyCount = everyCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
