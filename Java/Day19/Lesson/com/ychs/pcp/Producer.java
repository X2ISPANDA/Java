/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.pcp;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/01 16:33
 */
public class Producer implements Runnable {

    private Product product;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                product.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Gets the value of product
     *
     * @return the value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product
     * You can use getProduct() to get the value of product
     *
     * @param product product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        if(3>2)
            System.out.println(3);
    }
}
