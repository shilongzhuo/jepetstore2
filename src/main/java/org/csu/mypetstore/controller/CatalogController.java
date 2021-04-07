package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatelogService catelogService;

    @GetMapping("/view")
    public String view(){
        return "Main";
    }

    @GetMapping("/viewCategory")
    public String viewCategory(String categoryId, Model model){
        if(categoryId!=null){
            Category category = catelogService.getCategory(categoryId);
            List<Product> productList = catelogService.getProductListByCategory(categoryId);
            model.addAttribute("category",category);
            model.addAttribute("prductList",productList);
            return "Catagory";
        }
        else {
            return "Main";
        }
    }
}
