/*
 *   All Rights Reserved, Designed By Mingyu Xiong
 *
 */

package com.ychs.bean;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/07/16 22:45
 */
public class Car {
    private String brand;
    private String carNum;
    private String color;

    public void speed() {
        System.out.println("跑");
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the carNum
     */
    public String getCarNum() {
        return carNum;
    }

    /**
     * @param carNum the carNum to set
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", carNum=" + carNum + ", color=" + color + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }

        //自己和自己比较
        if(obj==this) {
            return true;
        }

        if(obj instanceof Car) {
            Car car = (Car) obj;
            return car.brand.equals(this.brand)&&car.carNum.equals(this.carNum)
                    &&car.color.equals(this.color);
        }


        return false;
    }


}
