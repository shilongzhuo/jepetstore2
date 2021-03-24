package org.csu.mypetstore.domain;

import java.io.Serializable;

//  购物车中的商品在数据库中存储的数据
public class CartItemInf implements Serializable {
    private static final long serialVersionUID = -2052543445426221956L;

    private String username;
    private String cartItemId;
    private String quantity;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCartItemId() {
        return this.cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
