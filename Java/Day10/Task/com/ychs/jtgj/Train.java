/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.jtgj;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/19 17:05
 */
public class Train implements IVehicle {
    @Override
    public void use() {
        System.out.println("火车开的块");
    }

    @Override
    public void stop() {
        System.out.println("火车呜呜呜");
    }
}
