package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.AdminService;
import org.csu.mypetstore.service.InventoryService;
import org.csu.mypetstore.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
@SessionAttributes({"username","account", "admin"})
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    VerificationService verificationService;
    @Autowired
    AdminService adminService;
    @Autowired
    InventoryService inventoryService;

    //登录或修改用户信息的验证码
    @GetMapping("/getVerification")
    @ResponseBody
    public String getVerification(Account account, Model model){
        if(accountService.getAccount(account.getUsername())==null){
            String message_ver = "用户名不存在";
            model.addAttribute("message_ver",message_ver);
            return message_ver;
        }else{
            verificationService.creatVerificationCodeByUsername(account.getUsername());
            String email = accountService.getAccount(account.getUsername()).getEmail();
            email = email.replace(email.substring(2,email.indexOf('@')-2),"*******");
            String message_ver = "已向 "+email+" 发送验证码";
            model.addAttribute("message_ver",message_ver);
            return message_ver;
        }
    }

    //注册时的验证码
    @PostMapping("/getVerificationSignOn")
    @ResponseBody
    public String getVerificationSignOn(Account account,Model model){
        if(account.getUsername().equals("")||account.getUsername()==null||account.getEmail().equals("")||account.getEmail()==null){
            String message_ver_sign = "缺少必要信息，请将注册信息填写完整";
            model.addAttribute("message_ver_sign",message_ver_sign);
            return message_ver_sign;
        }else{
            verificationService.creatVerificationCode(account);
            String email = account.getEmail();
            email = email.replace(email.substring(2,email.indexOf('@')-1),"*******");
            String message_ver_sign = "已向 "+email+" 发送验证码";
            model.addAttribute("message_ver_sign",message_ver_sign);
            return message_ver_sign;
        }
    }

    @GetMapping("/signon")
    @ResponseBody
    public String signon(Account account,String verification,String Fruit, Model model) {
        if(Fruit.equals("User")){
            if(verificationService.getVerificationCodeByUsername(account.getUsername())==null){//判断是否已经获得验证码
                String message_login = "请先获得验证码";
                model.addAttribute("message_login",message_login);
                return "account/login";
            }else if(!verificationService.getVerificationCodeByUsername(account.getUsername()).getCode().equals(verification)){//判断验证码是否正确
                String message_login = "验证码错误";
                model.addAttribute("message_login",message_login);
                return "account/login";
            }else{//判断用户名密码是否正确
                verificationService.delVerificationCodeByUsername(account.getUsername());
                if(accountService.getAccount(account.getUsername(), account.getPassword()) == null) {
                    String message_login = "用户名或密码错误";
                    model.addAttribute("message_login",message_login);
                    return "account/login";
                }
                else {
                    model.addAttribute("account",accountService.getAccount(account.getUsername(), account.getPassword()));
                    model.addAttribute("username",account.getUsername());
                    return "catalog/Main";
                }
            }
        }else{
            if(adminService.getAdmin(account.getUsername(),account.getPassword())!=null){
                model.addAttribute("admin",adminService.getAdmin(account.getUsername(),account.getPassword()));
                int[] BIRDS = {inventoryService.getSoldOutNumByByCategoryName("BIRDS"), inventoryService.getUnsoldNumByCategoryName("BIRDS"), inventoryService.getOrderedNumByCategoryName("BIRDS")};
                int[] CATS = {inventoryService.getSoldOutNumByByCategoryName("CATS"), inventoryService.getUnsoldNumByCategoryName("CATS"), inventoryService.getOrderedNumByCategoryName("CATS")};
                int[] DOGS = {inventoryService.getSoldOutNumByByCategoryName("DOGS"), inventoryService.getUnsoldNumByCategoryName("DOGS"), inventoryService.getOrderedNumByCategoryName("DOGS")};
                int[] FISH = {inventoryService.getSoldOutNumByByCategoryName("FISH"), inventoryService.getUnsoldNumByCategoryName("FISH"), inventoryService.getOrderedNumByCategoryName("FISH")};
                int[] REPTILES = {inventoryService.getSoldOutNumByByCategoryName("REPTILES"), inventoryService.getUnsoldNumByCategoryName("REPTILES"), inventoryService.getOrderedNumByCategoryName("REPTILES")};

                model.addAttribute("BirdList", BIRDS);
                model.addAttribute("CatList", CATS);
                model.addAttribute("DogList", DOGS);
                model.addAttribute("FishList", FISH);
                model.addAttribute("ReptileList", REPTILES);
                return "usual/index";
            }else{
                String message_login = "管理员用户名或密码错误";
                model.addAttribute("message_login",message_login);
                return "login";
            }
        }
    }

    @PostMapping("/newAccount")
    public String newAccount(Account account,String verification,Model model){
        if(account.getPassword()!=""||account.getPassword()!=null||account.getUsername()!=""||account.getUsername()!=null||account.getEmail()!=""||account.getEmail()!=null){
            if(!verificationService.getVerificationCodeByUsername(account.getUsername()).getCode().equals(verification)){
                model.addAttribute("message_new","验证码错误");
                return "验证码错误";
            }else{
                account.setLanguagePreference("english");
                account.setListOption(false);
                account.setBannerOption(false);
                account.setFavouriteCategoryId("CATS");
                accountService.insertAccount(account);
                model.addAttribute("message_new","注册用户成功");
                verificationService.delVerificationCodeByUsername(account.getUsername());
                return "注册用户成功";
            }
        }else{
            model.addAttribute("message_new","注册信息不完整");
            return "注册用户成功";
        }
    }

    @PostMapping("/checkAccount")
    @ResponseBody
    public String checkAccount(Account account){
        if(accountService.getAccount(account.getUsername())!=null){
            return "用户名已存在";
        }else{
            return "用户名可以使用";
        }
    }

    //获得用户信息
    @GetMapping("/getAccount")
    public String getAccount(Model model, HttpSession session){
//        if(session.getAttribute("account")!=null){
            model.addAttribute("account",session.getAttribute("account"));
            return "account/EditAccountForm";
//        }else{
//            return "account/login";
//        }
    }

    //获得用户信息
    @GetMapping("/signout")
    public String signout(HttpSession session,SessionStatus sessionStatus){
        session.invalidate();
        sessionStatus.setComplete();
        return "catalog/Main";
    }

    //修改用户信息
    @PostMapping("/updataAccount")
    public String updataAccount(Account account,String repeatedPassword,Model model){
        if(account.getPassword()!=""||repeatedPassword!=""||!account.getPassword().equals("")||!repeatedPassword.equals("")){
            if(!account.getPassword().equals(repeatedPassword)){
                model.addAttribute("amsg","两次输入的密码不同");
                return "account/EditAccountForm";
            }else{
                accountService.updateAccount(account);
                model.addAttribute("amsg","修改密码和用户信息成功");
                return "account/EditAccountForm";
            }
        }else{
            account.setPassword("");
            accountService.updateAccount(account);
            model.addAttribute("amsg","修改用户信息成功");
            return "account/EditAccountForm";
        }
    }

}
