package com.ychs.notebook;

/**
 * @author Mingyu Xiong
 * @description:筆記本類
 * @date 2019/07/21 15:07
 */
public class NoteBook {
    public void run() {
        System.out.println("笔记本运行中");
    }

    public void shutdown() {
        System.out.println("笔记本关机");
    }

    public void useUSB(IUsb usb) {
        // 判断是否有USB设备
        if (usb != null) {
            usb.open();
        }
    }

    public void closeUSB(IUsb usb) {
        // 判断是否有USB设备
        if (usb != null) {
            usb.close();
        }
    }
}

