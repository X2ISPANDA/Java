package com.ychs.ssm.day07.model;

/**
 * @author Mingyu Xiong
 * @description:地址表数据模型
 * @date 2020/3/31 18:28
 */
public class AddressInfo {
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
        return "AddressInfo{" +
                "addressId=" + addressId +
                ", addressInfo='" + addressInfo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
