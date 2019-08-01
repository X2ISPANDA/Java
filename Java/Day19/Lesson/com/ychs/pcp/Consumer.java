/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.pcp;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 16:36
 */
public class Consumer implements Runnable{
    private Product product;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                product.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
