package com.ychs.notebook;

/**
 * @author Mingyu Xiong
 * @description:鼠标
 * @date 2019/07/21 15:04
 */
public class Mouse implements IUsb {

    @Override
    public void open() {
        System.out.println("打开鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }
}
