package com.ychs.pojo;

public class School extends Page{
    private int id;
    private String schoolName;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
