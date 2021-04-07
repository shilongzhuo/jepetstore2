package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backstage")
public class BackStageController {

    @Autowired
    CatelogService catelogService;

    @Autowired
    AccountService accountService;

    @GetMapping("/categoryRename")
    public String categoryRename(String categoryId, String newId, String newName) {
//        Category category = catelogService.getCategory(categoryId);
//        category.setCategoryId(newId);
//        category.setName(newName);
//
//        catelogService.updateCategory(category);
        return "usual/goods";
    }

    @GetMapping("/accountRename")
    public String accountRename(String accountName, String newName){


        return "usual/users";
    }
}
