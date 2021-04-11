package org.csu.mypetstore.service;

import org.csu.mypetstore.common.EmailUtil;
import org.csu.mypetstore.common.SendSMSUtil;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Verification;
import org.csu.mypetstore.persistence.VerificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.Random;

@Service
public class VerificationService {

    @Autowired
    VerificationMapper verificationMapper;
    @Autowired
    AccountService accountService;

    //用户点击获取验证码
    @Transactional
    public void creatVerificationCodeByUsername(String username){

        //生成验证码字符串
        String code = "";
        Random ra = new Random(System.currentTimeMillis());
        for(int i=0;i<6;i++){
            code += ra.nextInt(10);
        }

        //将生成的验证码保存在数据库
        if(verificationMapper.getVerificationCodeByUsername(username)==null){
            verificationMapper.creatVerificationCodeByUsername(username, code);
        }else{
            verificationMapper.updateVerificationCodeByUsername(username, code);
        }

        //获取用户邮箱信息
        String email = accountService.getAccount(username).getEmail();

//        //发送验证码到用户手机
//        SendSMSUtil sendSMSUtil = new SendSMSUtil();
//        try {
//            sendSMSUtil.sendSMS(phone,code);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //发送验证码到用户邮箱
        try {
            EmailUtil.sendEmail(email,code);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

    }

    //注册时的验证码
    @Transactional
    public void creatVerificationCode(Account account){

        //生成验证码字符串
        String code = "";
        Random ra = new Random(System.currentTimeMillis());
        for(int i=0;i<6;i++){
            code += ra.nextInt(10);
        }

        //将生成的验证码保存在数据库
        if(verificationMapper.getVerificationCodeByUsername(account.getUsername())==null){
            verificationMapper.creatVerificationCodeByUsername(account.getUsername(), code);
        }else{
            verificationMapper.updateVerificationCodeByUsername(account.getUsername(), code);
        }

        //获取用户邮箱信息
        String email = account.getEmail();

//        //发送验证码到用户手机
//        SendSMSUtil sendSMSUtil = new SendSMSUtil();
//        try {
//            sendSMSUtil.sendSMS(phone,code);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //发送验证码到用户邮箱
        try {
            EmailUtil.sendEmail(email,code);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

    }

    //删除验证码（时间到了/验证成功）
    @Transactional
    public void delVerificationCodeByUsername(String username){
        verificationMapper.delVerificationCodeByUsername(username);
    }

    //查询验证码
    public Verification getVerificationCodeByUsername(String username){
        return verificationMapper.getVerificationCodeByUsername(username);
    }


}
