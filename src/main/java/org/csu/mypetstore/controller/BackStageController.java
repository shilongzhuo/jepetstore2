package org.csu.mypetstore.controller;

import org.bouncycastle.math.raw.Mod;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/backstage")
public class BackStageController {

    @Autowired
    CatelogService catelogService;

    @Autowired
    AccountService accountService;

    @GetMapping("/categoryRename")
    public String categoryRename(Model model) {
        // 读取数据库，查询商品种类
        List<Category> categoryList = catelogService.getCategoryList();
        model.addAttribute("categoryList", categoryList);
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
        // 想数据库查询所有用户信息
        List<Account> accountList = accountService.geAccountList();
        model.addAttribute("accountList", accountList);
        return "usual/users";
    }

    @GetMapping("/userRemove")
    public String accountRemove(Model model){
        // 想数据库查询所有用户信息
        List<Account> accountList = accountService.geAccountList();
        model.addAttribute("accountList", accountList);
        return "usual/users";
    }
}
