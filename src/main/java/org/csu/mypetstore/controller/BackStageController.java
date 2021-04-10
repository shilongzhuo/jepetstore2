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
    public String categoryRename(Model model, String oldName, String newName) {

        // 更新小类名称


        // 读取数据库，查询商品大类
        List<Category> categoryList = catelogService.getCategoryList();
        int num = categoryList.size();
        List<Product> productList = new ArrayList<>();
        // 根据大类获取所有小类
        for(int i = 0; i < num; i++) {
            List<Product> productList1 = catelogService.getProductListByCategory(categoryList.get(i).getName());
            for(int j = 0; j < productList1.size(); j++){
                productList.add(productList1.get(j));
            }
        }
        model.addAttribute("productList", productList);
        return "usual/goods";
    }

    @GetMapping("/categoryRemove")
    public String categoryRemove(String categoryId, Model model){
        // 读取数据库，查询商品种类
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
