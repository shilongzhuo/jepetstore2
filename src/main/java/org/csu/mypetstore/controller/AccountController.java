package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.AdminService;
import org.csu.mypetstore.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    VerificationService verificationService;
    @Autowired
    AdminService adminService;

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
    @GetMapping("/getVerificationSignOn")
    @ResponseBody
    public String getVerificationSignOn(Account account,Model model){
        if(account.getUsername().equals("")||account.getUsername()==null||account.getEmail().equals("")||account.getEmail()==null){
            String message_ver_sign = "缺少必要信息，请将注册信息填写完整";
            model.addAttribute("message_ver_sign",message_ver_sign);
            return message_ver_sign;
        }else{
            verificationService.creatVerificationCodeByUsername(account.getUsername());
            String email = accountService.getAccount(account.getUsername()).getEmail();
            email = email.replace(email.substring(2,email.indexOf('@')-1),"*******");
            String message_ver = "已向 "+email+" 发送验证码";
            model.addAttribute("message_ver",message_ver);
            return message_ver;
        }
    }

    @PostMapping("/signon")
    public String signon(Account account,String verification,String Fruit, Model model) {
        if(Fruit.equals("User")){
            if(verificationService.getVerificationCodeByUsername(account.getUsername())==null){//判断是否已经获得验证码
                String message_login = "请先获得验证码";
                model.addAttribute("message_login",message_login);
                return "account/login";
            }else if(!verificationService.getVerificationCodeByUsername(account.getUsername()).getCode().equals(verification)){//判断验证码是否正确
                System.out.println(verificationService.getVerificationCodeByUsername(account.getUsername()).getCode());
                String message_login = "验证码错误";
                model.addAttribute("message_login",message_login);
                return "account/login";
            }else{//判断用户名密码是否正确
                if(accountService.getAccount(account.getUsername(), account.getPassword()) == null) {
                    String message_login = "用户名或密码错误";
                    model.addAttribute("message_login",message_login);
                    return "account/login";
                }
                else {
                    return "catalog/Catagory";
                }
            }
        }else{
            if(adminService.getAdmin(account.getUsername(),account.getPassword())!=null){
                return "usual/index";
            }else{
                String message_login = "管理员用户名或密码错误";
                model.addAttribute("message_login",message_login);
                return "account/login";
            }
        }
    }

}
