package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    // 根据用户名获取用户对象
    public Account getAccount (String username) {
        return accountMapper.getAccountByUsername(username);
    }

    // 根据用户名和密码获取用户对象
    public Account getAccount(String username, String password) {
        return accountMapper.getAccountByUsernameAndPassword(username, password);
    }

    /* @Transactional 是声明式事务管理
    *
    *   插入新用户
    *
     */
    @Transactional
    public void insertAccount (Account account){
        accountMapper.insertAccount(account);
        accountMapper.insertProfile(account);
        accountMapper.insertSignon(account);
    }

    // 更新用户数据，要求密码不为空
    @Transactional
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
        accountMapper.updateProfile(account);

        if(account.getPassword() != null && account.getPassword().length() > 0) {
            accountMapper.updateSignon(account);
        }
    }
}
