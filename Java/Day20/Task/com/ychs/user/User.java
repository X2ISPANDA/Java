/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.user;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/08/05 15:49
 */
public class User {
    private String username;
    private String password;

    /**
     * Gets the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     * You can use getUsername() to get the value of username
     *
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     * You can use getPassword() to get the value of password
     *
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
interface UserDao {
    boolean getUser(User user) throws IllegalPasswordException;
}

class IllegalPasswordException extends Exception {
    public IllegalPasswordException() {

    }

    public IllegalPasswordException(String msg) {
        System.out.println(msg);
    }
}
