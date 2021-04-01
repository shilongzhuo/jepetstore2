package org.csu.mypetstore.domain;

import java.io.Serializable;

public class Verification implements Serializable {

    private static final long serialVersionUID = -665197850050478998L;
    private String username;
    private String code;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
