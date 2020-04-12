package com.ychs.ssm.day07.model;

/**
 * @author Mingyu Xiong
 * @description:地址数据模型,一对多关系
 * @date 2020/4/1 14:41
 */
public class Address {

    private int addressId;

    private String addressInfo;

    private String remark;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", addressInfo='" + addressInfo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
