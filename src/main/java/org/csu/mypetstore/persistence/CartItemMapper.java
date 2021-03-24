package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.CartItemInf;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemMapper {

    void insertCartItem(String username,String cartItemId,int quantity);

    void delCartItem(String username,String cartItemId);

    void updateCartItem(String username,String cartItemId,int quantity);

    List<CartItemInf> getCartItemByUsername(String username);
}
