package org.csu.mypetstore.controller;

import org.csu.mypetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/upload")
    public String upload() {
        return "/usual/upload";

    }

//    @GetMapping("/modify")
//    public String modify() {
//        return null;
//    }

    @PostMapping("/signon")
    public String signon(String username, String password, Model model) {
        // 登录失败或成功
        if(accountService.getAccount(username, password) == null) {
            model.addAttribute("msg", "用户名或密码错误");
            return "/usual/upload";
        }
        else {
            return "/usual/index";
        }
    }
}
