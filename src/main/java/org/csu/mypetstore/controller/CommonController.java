package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.InventoryMapper;
import org.csu.mypetstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class CommonController {

    @Autowired
    CatelogService catelogService;

    @Autowired
    AccountService accountService;

    @Autowired
    OrderService orderService;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    AdminService adminService;

    // 判断是否登录为管理员
    private boolean isAdmin(HttpSession session) {
        String adminName = (String)session.getAttribute("admin");
        if (adminName == null){
            return false;
        } else return true;
    }

    @GetMapping("/index")
    public String index(Model model, HttpSession session){

        if(isAdmin(session)){
            int[] BIRDS = {inventoryService.getSoldOutNumByByCategoryName("BIRDS"), inventoryService.getUnsoldNumByCategoryName("BIRDS"), inventoryService.getOrderedNumByCategoryName("BIRDS")};
            int[] CATS = {inventoryService.getSoldOutNumByByCategoryName("CATS"), inventoryService.getUnsoldNumByCategoryName("CATS"), inventoryService.getOrderedNumByCategoryName("CATS")};
            int[] DOGS = {inventoryService.getSoldOutNumByByCategoryName("DOGS"), inventoryService.getUnsoldNumByCategoryName("DOGS"), inventoryService.getOrderedNumByCategoryName("DOGS")};
            int[] FISH = {inventoryService.getSoldOutNumByByCategoryName("FISH"), inventoryService.getUnsoldNumByCategoryName("FISH"), inventoryService.getOrderedNumByCategoryName("FISH")};
            int[] REPTILES = {inventoryService.getSoldOutNumByByCategoryName("REPTILES"), inventoryService.getUnsoldNumByCategoryName("REPTILES"), inventoryService.getOrderedNumByCategoryName("REPTILES")};

            model.addAttribute("BirdList", BIRDS);
            model.addAttribute("CatList", CATS);
            model.addAttribute("DogList", DOGS);
            model.addAttribute("FishList", FISH);
            model.addAttribute("ReptileList", REPTILES);
            return "usual/index";
        } else
            return "catalog/Main";

    }

    @GetMapping("/goods")
    public String goods(Model model, HttpSession session) {

        if (isAdmin(session)) {
            List<Product> productList = catelogService.getAllProducts();
            model.addAttribute("productList", productList);

            return "usual/goods";
        }
        else
            return "catalog/Main";

    }

    @GetMapping("/users")
    public String users(Model model, HttpSession session){

        if(isAdmin(session)) {
            // 向数据库查询所有用户信息
            List<Account> accountList = accountService.getAccountList();
            model.addAttribute("accountList", accountList);
            return "usual/users";
        }
        else
            return "catalog/Main";

    }

    @GetMapping("/order")
    public String order(Model model, HttpSession session){

        if (isAdmin(session)) {
            // 向数据库查询所有订单信息
            List<Order> orderList = orderService.getAllOrders();
            model.addAttribute("orderList", orderList);
            return "usual/order";
        } else
            return "catalog/Main";


    }

    @GetMapping("/infor")
    public String infor(HttpSession session){
        if (isAdmin(session))
            return "usual/infor";
        else
            return "catalog/Main";
    }

    @GetMapping("/login")
    public String login(){
        return "account/login";
    }

    @GetMapping("/newAccount")
    public String signon(){
        return "account/NewAccountForm";
    }
}
