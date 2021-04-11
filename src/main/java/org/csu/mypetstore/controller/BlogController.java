package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Blog;
import org.csu.mypetstore.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/getBlog")
    public String getBlog(Model model,HttpSession session){
        if(session.getAttribute("account")==null){
            return "account/login";
        }else{
            String username = session.getAttribute("username").toString();
            List<Blog> blogList = blogService.getBlogByUsername(username);
            model.addAttribute("blogList",blogList);
            return "blog/Blog";
        }
    }
}
