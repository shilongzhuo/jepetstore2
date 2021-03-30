package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemMapper {

    void insertCartItem(String username,String cartItemId);

    void delCartItem(String username,String cartItemId);

    void updateCartItem(String username,String cartItemId,int quantity);

    List<String> getCartItemIdByUsername(String username);

    CartItem getCartItemByUsernameAndItemId(String username, String cartItemId);
}
