package org.csu.mypetstore.controller;


import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CatelogService catelogService;
    @Autowired
    CartService cartService;

    //点击添加到购物车
    @ResponseBody
    @GetMapping(value = "/addItem")
    public ModelAndView addItem(String itemId){
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();
        ModelAndView modelAndView;
        if(catelogService.getItem(itemId)==null){
            modelAndView = new ModelAndView("catalog/Main");
        } else if (session.getAttribute("username")==null||session.getAttribute("usename")=="") {
            modelAndView = new ModelAndView("account/login");
        } else {
            cartService.insertCartItem((String) session.getAttribute("username"), itemId);
            modelAndView = new ModelAndView("catalog/Item");
            Item item =  catelogService.getItem(itemId);
            Product product = catelogService.getProduct(item.getProductId());
            modelAndView.addObject("item",item);
            modelAndView.addObject("product",product);
        }
        return modelAndView;
    }

    //点击购物车中的remove
    @ResponseBody
    @GetMapping("/removeItem")
    public ModelAndView removeItem(String itemId){
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();
        ModelAndView modelAndView;
        if (session.getAttribute("account")==null) {
            modelAndView = new ModelAndView("catalog/Main");
        } else if(cartService.getCartItemByUsernameAndItemId((String)session.getAttribute("username"),itemId)==null){
            modelAndView = new ModelAndView("cart/Cart");
            Cart cart = cartService.getCartByUsername((String)session.getAttribute("username"));
            String message_cart = itemId + "已不在购物车中";
            modelAndView.addObject("cart",cart);
            modelAndView.addObject("message_cart",message_cart);
        } else {

            cartService.delCartItem((String) session.getAttribute("username"),itemId);
            modelAndView = new ModelAndView("cart/Cart");
            Cart cart = cartService.getCartByUsername((String)session.getAttribute("username"));
            String message_cart = itemId + "从购物车删除成功";
            modelAndView.addObject("cart",cart);
            modelAndView.addObject("message_cart",message_cart);
        }
        return modelAndView;
    }

    //修改购物车中的商品数量
    @ResponseBody
    @PostMapping("/updateItem")
    public ModelAndView updateItem(String cartItemId,int quantity){

        System.out.println(cartItemId+quantity);

        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();
        ModelAndView modelAndView;
        if (session.getAttribute("account")==null) {
            modelAndView = new ModelAndView("catalog/Main");
        } else if(cartService.getCartItemByUsernameAndItemId((String)session.getAttribute("username"),cartItemId)==null){
            modelAndView = new ModelAndView("cart/Cart");
            Cart cart = cartService.getCartByUsername((String)session.getAttribute("username"));
            String message_cart = cartItemId + "已不在购物车中";
            modelAndView.addObject("cart",cart);
            modelAndView.addObject("message_cart",message_cart);
        } else {
            if(quantity<=0){
                cartService.delCartItem((String)session.getAttribute("username"),cartItemId);
                modelAndView = new ModelAndView("cart/Cart");
                Cart cart = cartService.getCartByUsername((String)session.getAttribute("username"));
                String message_cart = cartItemId + "从购物车删除成功";
                modelAndView.addObject("cart",cart);
                modelAndView.addObject("message_cart",message_cart);
            }else{
                cartService.updateCartItem((String)session.getAttribute("username"),cartItemId,quantity);
                modelAndView = new ModelAndView("cart/Cart");
                Cart cart = cartService.getCartByUsername((String)session.getAttribute("username"));
                String message_cart = cartItemId + "数量修改成功";
                modelAndView.addObject("cart",cart);
                modelAndView.addObject("message_cart",message_cart);
            }
        }
        return modelAndView;
    }


    //跳转到购物车页面并查询购物车信息
    @GetMapping("/viewCart")
    public String viewCart(Model model,HttpSession session){
        if (session.getAttribute("account")==null) {
            String message_account = "登录信息缺失，请重新登陆";
            model.addAttribute("message_account",message_account);
            return "account/login";
        } else{
            Cart cart = cartService.getCartByUsername((String)session.getAttribute("username"));
            model.addAttribute("cart",cart);
            return "cart/Cart";
        }
    }

    //检查确认购物车信息
    @GetMapping("/confirmCart")
    public String confirmCart(Model model,HttpSession session){
        if (session.getAttribute("account")==null) {
            String message_account = "登录信息缺失，请重新登陆";
            model.addAttribute("message_account",message_account);
            return "account/login";
        } else{
            Cart cart = cartService.getCartByUsername((String)session.getAttribute("username"));
            model.addAttribute("cart",cart);
            return "cart/Checkout";
        }
    }

}
