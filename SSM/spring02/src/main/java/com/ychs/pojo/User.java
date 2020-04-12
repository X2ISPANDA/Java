package com.ychs.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/7 21:14
 */
@Component(value = "user")
public class User {

    private int id;
    @Value("zs")
    private String name;
    private String sex;
    /*@Autowired
    @Qualifier(value = "phone2")*/
    @Resource(name = "phone")
    private Phone phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁。。。");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone=" + phone +
                '}';
    }
}
