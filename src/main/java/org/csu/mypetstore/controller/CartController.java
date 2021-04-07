package org.csu.mypetstore.controller;


import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CatelogService catelogService;
    @Autowired
    CartService cartService;

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


    //跳转到购物车页面并查询购物车信息
    @GetMapping("/viewCart")
    public String viewCart(Model model){
        if (model.getAttribute("account")==null) {
            String message_account = "登录信息缺失，请重新登陆";
            model.addAttribute("message_account",message_account);
            return "account/login";
        } else{
            Cart cart = cartService.getCartByUsername((String)model.getAttribute("username"));
            model.addAttribute("cart",cart);
            return "cart/Cart";
        }
    }

}
