package org.csu.mypetstore.controller;

import org.csu.mypetstore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/signon")
    public String signon(String username, String password) {

        // 登录失败或成功
        if(accountService.getAccount(username, password) == null) {
            return "/signon";
        }
        else {
            return "/catalog/main";
        }
    }

    @GetMapping("/modify")
    public String modify() {
        return null;
    }

}
