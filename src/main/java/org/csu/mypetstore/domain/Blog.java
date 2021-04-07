package org.csu.mypetstore.domain;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable {

    private static final long serialVersionUID = -8529596880476372184L;
    private String username;
    private String description;
    private Date orderDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
