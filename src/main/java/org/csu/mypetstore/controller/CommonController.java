package org.csu.mypetstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class CommonController {

    @GetMapping("/index")
    public String index(){
        return "usual/index";
    }

    @GetMapping("/goods")
    public String goods() {
        return "usual/goods";
    }

    @GetMapping("/users")
    public String users(){
        return "usual/users";
    }

    @GetMapping("/order")
    public String order(){
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
