package com.ychs.notebook;

/**
 * @author Mingyu Xiong
 * @description:USB接口
 * @date 2019/07/21 14:45
 */
public interface IUsb {
    /**
     * USB具备开启功能
     */
    void open();

    /**
     * USB具备关闭功能
     */
    void close();

}
