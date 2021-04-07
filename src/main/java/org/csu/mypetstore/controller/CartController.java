package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    CatelogService catelogService;
    @Autowired
    AccountService accountService;

    @GetMapping("/cart")
    public String cart(String username, Model model){
        if(username == null){
            return "account/login";
        }
        else {
            List<CartItem> cartList = cartService.getCartItemByUsername(username);
            model.addAttribute("cart", cartList);
            return "cart/Cart";
        }
    }

    @GetMapping("/checkOut")
    public String checkOut(Model model){
        return "cart/Checkout";
    }

    @GetMapping("/viewItem")
    public String viewItem(String itemId, Model model) {

        return "";
    }

    //点击添加到购物车
    @GetMapping("/addItem")
    public void addItem(String itemId, Model model){
        if(catelogService.getItem(itemId)==null){
            String message_add_item = itemId + "已经不再销售";
            model.addAttribute("message_add_item",message_add_item);
        } else if (model.getAttribute("username")==null) {
            String message_add_item = "登录信息缺失，请重新登陆";
            model.addAttribute("message_add_item",message_add_item);
        } else {
            cartService.insertCartItem((String) model.getAttribute("username"), itemId);
            String message_add_item = itemId + "添加到购物车成功";
            model.addAttribute("message_add_item", message_add_item);
        }
    }

    //点击购物车中的remove
    @GetMapping("/removeItem")
    public void removeItem(String itemId,Model model){
        if (model.getAttribute("account")==null) {
            String message_add_item = "登录信息缺失，请重新登陆";
            model.addAttribute("message_update_item",message_add_item);
        } else if(cartService.getCartItemByUsernameAndItemId((String)model.getAttribute("username"),itemId)==null){
            String message_add_item = itemId + "已经不在购物车中";
            model.addAttribute("message_update_item",message_add_item);
        } else {
            cartService.delCartItem((String)model.getAttribute("username"),itemId);
            String message_add_item = itemId + "从购物车删除成功";
            model.addAttribute("message_update_item", message_add_item);
        }
    }

    //修改购物车中的商品数量
    @GetMapping("/updateItem")
    public void updateItem(String cartItemId,int quantity,Model model){
        if (model.getAttribute("account")==null) {
            String message_update_item = "登录信息缺失，请重新登陆";
            model.addAttribute("message_update_item",message_update_item);
        } else if(cartService.getCartItemByUsernameAndItemId((String)model.getAttribute("username"),cartItemId)==null){
            String message_update_item = cartItemId + "已经不在购物车中";
            model.addAttribute("message_update_item",message_update_item);
        } else {
            if(quantity<=0){
                cartService.delCartItem((String)model.getAttribute("username"),cartItemId);
                String message_update_item = cartItemId + "从购物车删除成功";
                model.addAttribute("message_update_item", message_update_item);
            }else{
                cartService.updateCartItem((String)model.getAttribute("username"),cartItemId,quantity);
                String message_update_item = cartItemId + "数量修改成功";
                model.addAttribute("message_update_item", message_update_item);
            }
        }
    }



}
