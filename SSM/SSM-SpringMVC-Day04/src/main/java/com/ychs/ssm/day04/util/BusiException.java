package com.ychs.ssm.day04.util;

/**
 * @author Mingyu Xiong
 * @description:自定义异常类
 * @date 2020/3/20 17:24
 */
public class BusiException extends Exception {
    private String errorCode;

    private String errorMessage;

    public BusiException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
