package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatelogService;
import org.csu.mypetstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


    @GetMapping("/index")
    public String index(){
        return "usual/index";
    }

    @GetMapping("/goods")
    public String goods(Model model) {

        List<Product> productList = catelogService.getAllProducts();
        model.addAttribute("productList", productList);

        return "usual/goods";
    }

    @GetMapping("/users")
    public String users(Model model){

        // 向数据库查询所有用户信息
        List<Account> accountList = accountService.geAccountList();
        model.addAttribute("accountList", accountList);
        return "usual/users";
    }

    @GetMapping("/order")
    public String order(Model model){

        // 向数据库查询所有订单信息
        List<Order> orderList = orderService.getAllOrders();
        model.addAttribute("orderList", orderList);
        return "usual/order";
    }

    @GetMapping("/infor")
    public String infor(){
        return "usual/infor";
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
