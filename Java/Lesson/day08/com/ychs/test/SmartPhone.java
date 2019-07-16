/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.test;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/16 16:01
 */
public class SmartPhone extends Phone {
    @Override
    public void call() {
        super.call();
        System.out.println("打视频电话");
    }

    @Override
    public void send() {
        super.send();
        System.out.println("发彩信");
    }

    public void surf() {
        System.out.println("上网");
    }

    public void game() {
        System.out.println("打游戏");
    }

    public void qiezi() {
        System.out.println("拍照");
    }

    public void videoTalk() {
        System.out.println("视频聊天");
    }
}


