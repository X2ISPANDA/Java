/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.demo;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/24 17:05
 */
public class Grade{
    private String name;
    private int score;

    @Override
    public String toString() {
        return name+":"+score;
    }

    /**
     * Gets the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * You can use getName() to get the value of name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of score
     *
     * @return the value of score
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score
     * You can use getScore() to get the value of score
     *
     * @param score score
     */
    public void setScore(int score) {
        this.score = score;
    }
}
