package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatelogService catelogService;

    @GetMapping("/view")
    public String view(){
        return "catalog/Main";
    }

    @GetMapping("/viewCategory")
    public String viewCategory(String categoryId, Model model){
        if(categoryId!=null){
            Category category = catelogService.getCategory(categoryId);
            List<Product> productList = catelogService.getProductListByCategory(categoryId);
            model.addAttribute("category",category);
            model.addAttribute("prductList",productList);
            return "catalog/Catagory";
        }
        else {
            return "catalog/Main";
        }
    }

    @GetMapping("/viewProduct")
    public String viewProduct(String productId, Model model){
        if(productId!=null){
            Product product = catelogService.getProduct(productId);
            List<Item> itemList = catelogService.getItemListByProduct(productId);
            model.addAttribute("product",product);
            model.addAttribute("itemList",itemList);
            return "catalog/Product";
        }
        else {
            return "catalog/Main";
        }
    }

    @GetMapping("/viewItem")
    public String viewItem(String itemId, Model model){
        if(itemId!=null){
            Item item = catelogService.getItem(itemId);
            model.addAttribute("item",item);
            return "catalog/Item";
        }
        else {
            return "catalog/Main";
        }
    }

    @PostMapping("/search")
    public String search(String keyword,Model model){
        model.addAttribute("productListSelect",catelogService.searchProductList("%"+keyword+"%"));
        return  "catalog/SearchProducts";
    }
}
