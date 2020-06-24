package com.ychs.pojo;

public class Role {
    private String roleid;
    private String roleName;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid='" + roleid + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
