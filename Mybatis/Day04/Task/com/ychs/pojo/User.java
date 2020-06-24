package com.ychs.pojo;

import java.util.List;

public class User {
    private String id;
    private String username;
    private String password;
    private String roleid;

    private List<Menu> menu;

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleid='" + roleid + '\'' +
                ", menu=" + menu +
                '}';
    }
}
