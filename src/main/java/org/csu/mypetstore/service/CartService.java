package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.persistence.CartItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//购物车持久化
@Service
public class CartService {

    //购物车中的商品信息
    @Autowired
    private CartItemMapper cartItemMapper;

    //向购物车中插入单个商品
    @Transactional
    public void insertCartItem(String username,String cartItemId){
        CartItem cartItem = cartItemMapper.getCartItemByUsernameAndItemId(username, cartItemId);
        if(cartItem != null){
            cartItemMapper.updateCartItem(username,cartItemId,cartItem.getQuantity()+1);
        }else{
            cartItemMapper.insertCartItem(username,cartItemId);
        }
    }

    //从购物车中删除某件商品
    @Transactional
    public void delCartItem(String username,String cartItemId){
        cartItemMapper.delCartItem(username,cartItemId);
    }

    //更新购物车中的信息（插入多个商品或修改多个商品的数量）
    @Transactional
    public void updateCartItem(String username,String cartItemId,int quantity){
        if(quantity<=0){
            cartItemMapper.delCartItem(username, cartItemId);
        }else{
            cartItemMapper.updateCartItem(username,cartItemId,quantity);
        }
    }

    //获得用户购物车中的全部商品信息
    public List<CartItem> getCartItemByUsername(String username){
        List<String> cartItemIdList = cartItemMapper.getCartItemIdByUsername(username);
        List<CartItem> cartItemList = new ArrayList<CartItem>();
        for(int i=0;i<cartItemIdList.size();i++){
            cartItemList.add(cartItemMapper.getCartItemByUsernameAndItemId(username,cartItemIdList.get(i)));
        }
        return  cartItemList;
    }

    //获取某个商品
    public CartItem getCartItemByUsernameAndItemId(String username,String cartItemId){
        CartItem cartItem = cartItemMapper.getCartItemByUsernameAndItemId(username, cartItemId);
        cartItem.setQuantity(cartItem.getQuantity());
        cartItem.setInStock(cartItem.getItem().getQuantity()>=cartItem.getQuantity());
        return cartItem;
    }

    //获取整个购物车
    public Cart getCartByUsername(String username){
        Cart cart = new Cart();
        List<CartItem> cartItemList = getCartItemByUsername(username);
        for(int i=0;i<cartItemList.size();i++){
            cart.addItem(cartItemList.get(i).getItem(),cartItemList.get(i).isInStock());
            int quantity = cartItemList.get(i).getQuantity();
            String itemId = cartItemList.get(i).getItem().getItemId();
            for(int p=0;p<quantity-1;p++){
                cart.incrementQuantityByItemId(itemId);
            }
        }
        return cart;
    }
}
