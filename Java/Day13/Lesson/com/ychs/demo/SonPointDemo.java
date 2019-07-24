/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/23 14:46
 */
public class SonPointDemo<M,N,K,V> extends PointDemo2<M,N,K> {
    @Override
    public M getX() {
            return super.getX();
    }

    @Override
    public void setX(M x) {
        super.setX(x);
    }

    @Override
    public N getY() {
        return super.getY();
    }

    @Override
    public void setY(N y) {
        super.setY(y);
    }

    @Override
    public K getZ() {
        return super.getZ();
    }

    @Override
    public void setZ(K z) {
        super.setZ(z);
    }

}
