package org.csu.mypetstore.controller;

import org.bouncycastle.math.raw.Mod;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/backstage")
public class BackStageController {

    @Autowired
    CatelogService catelogService;

    @Autowired
    AccountService accountService;

    @Autowired
    OrderService orderService;


    @PostMapping("/categoryRename")
    public String categoryRename(String oldProductId, String newName, Model model) {

        // 更新小类名称
        Product product = catelogService.getProduct(oldProductId);
        product.setName(newName);
        catelogService.updateProduct(product);

        // 重新上传数据
        List<Product> productList = catelogService.getAllProducts();
        model.addAttribute("productList", productList);
        return "usual/goods";
    }

    @PostMapping("/categoryRemove")
    public String categoryRemove(String productId, Model model){

        // 删除小类
        catelogService.delProductByProductId(productId);

        // 重新上传数据
        List<Category> categoryList = catelogService.getCategoryList();
        model.addAttribute("categoryList", categoryList);
        return "usual/goods";
    }
    @GetMapping("/userRename")
    public String accountRename(String accountName, String newName, Model model){
        // 向数据库查询所有用户信息
        List<Account> accountList = accountService.geAccountList();
        model.addAttribute("accountList", accountList);
        return "usual/users";
    }

    @GetMapping("/userRemove")
    public String accountRemove(Model model){
        // 向数据库查询所有用户信息
        List<Account> accountList = accountService.geAccountList();
        model.addAttribute("accountList", accountList);
        return "usual/users";
    }

    @GetMapping("/orderRemove")
    public String orderRemove(Model model){
        // 向数据库查询所有订单信息
        List<Order> orderList = orderService.getAllOrders();
        model.addAttribute("orderList", orderList);
        return "usual/order";
    }

    @GetMapping("/orderDeliver")
    public String orderDeliver(Model model){
        // 向数据库查询所有订单信息
        List<Order> orderList = orderService.getAllOrders();
        model.addAttribute("orderList", orderList);
        return "usual/order";
    }
}
