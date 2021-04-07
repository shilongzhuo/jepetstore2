package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/main")
public class CommonController {

    @Autowired
    CatelogService catelogService;

    @GetMapping("/index")
    public String index(){
        return "usual/index";
    }

    @GetMapping("/goods")
    public String goods(Model model) {

        // 获取所有商品，传给前端
        List<Category> allProduct = catelogService.getCategoryList();
        model.addAttribute("allProductList", allProduct);

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


}
