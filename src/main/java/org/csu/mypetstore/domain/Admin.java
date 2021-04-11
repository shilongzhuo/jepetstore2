package org.csu.mypetstore.domain;

import java.io.Serializable;

public class Admin implements Serializable {

    private static final long serialVersionUID = 1477065758104747447L;
    private String adminId;
    private String password;

    public String getAdminId() {
        return this.adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
