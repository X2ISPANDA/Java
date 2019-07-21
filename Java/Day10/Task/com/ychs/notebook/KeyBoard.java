package com.ychs.notebook;

/**
 * @author Mingyu Xiong
 * @description:键盘
 * @date 2019/07/21 15:05
 */
public class KeyBoard implements IUsb {
    @Override
    public void open() {
        System.out.println("键盘开启");
    }

    @Override
    public void close() {
        System.out.println("键盘关闭");
    }
}
