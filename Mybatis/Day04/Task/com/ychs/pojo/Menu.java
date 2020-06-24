package com.ychs.pojo;

import java.util.List;

public class Menu {
    private String menuid;
    private String menuName;
    private String url;
    private String pid;

    private List<Menu> menu;

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuid='" + menuid + '\'' +
                ", menuName='" + menuName + '\'' +
                ", url='" + url + '\'' +
                ", pid='" + pid + '\'' +
                ", menu=" + menu +
                '}';
    }
}
