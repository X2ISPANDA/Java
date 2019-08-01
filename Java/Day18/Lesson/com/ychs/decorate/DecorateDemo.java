/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.decorate;

/**
 * @author Mingyu Xiong
 * @description:装饰器模式 实现放大器对声音的放大功能
 * @date 2019/07/31 11:56
 */
public class DecorateDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.say();

        Amplifier am = new Amplifier(person);
        am.say();

    }


}

interface Say {
    void say();
}

class Person implements Say {

    //属性
    private int voice = 10;

    @Override
    public void say() {
        System.out.println("人的声音为:"+this.getVoice());
    }

    /**
     * Gets the value of voice
     *
     * @return the value of voice
     */
    public int getVoice() {
        return voice;
    }

    /**
     * Sets the voice
     * You can use getVoice() to get the value of voice
     *
     * @param voice voice
     */
    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Say {
    private Person person;

    Amplifier(Person person) {
        this.person = person;
    }

    @Override
    public void say() {
        System.out.println("人的声音为: "+person.getVoice()*100);
        System.out.println("噪音...");
    }
}