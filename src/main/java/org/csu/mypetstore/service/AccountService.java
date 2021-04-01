package org.csu.mypetstore.service;

import org.csu.mypetstore.common.MD5Util;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    //个人信息
    @Autowired
    private AccountMapper accountMapper;

    public Account getAccount(String username) {
        return accountMapper.getAccountByUsername(username);
    }

    public Account getAccount(String username, String password) {
        //数据库中搜索时用加密后的密码进行搜索
        return accountMapper.getAccountByUsernameAndPassword(username,MD5Util.md5(password));
    }

    //用户注册
    @Transactional
    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
        accountMapper.insertProfile(account);
        //对用户密码进行加密
        account.setPassword(MD5Util.md5(account.getPassword()));
        accountMapper.insertSignon(account);
    }

    //用户信息修改
    @Transactional
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
        accountMapper.updateProfile(account);

        if (account.getPassword() != null && account.getPassword().length() > 0) {
            //对用户密码进行加密
            account.setPassword(MD5Util.md5(account.getPassword()));
            accountMapper.updateSignon(account);
        }
    }
}
