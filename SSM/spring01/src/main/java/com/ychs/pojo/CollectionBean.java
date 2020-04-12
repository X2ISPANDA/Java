package com.ychs.pojo;

import java.util.*;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/4/6 12:50
 */
public class CollectionBean {
    private int[] arr;
    private List<Person> list;
    private Set set;
    private Map<String,Phone> map;
    private Properties prop;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map<String, Phone> getMap() {
        return map;
    }

    public void setMap(Map<String, Phone> map) {
        this.map = map;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "arr=" + Arrays.toString(arr) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", prop=" + prop +
                '}';
    }
}
