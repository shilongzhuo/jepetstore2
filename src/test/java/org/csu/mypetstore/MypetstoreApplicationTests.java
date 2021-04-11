package org.csu.mypetstore;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Admin;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.persistence.AccountMapper;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.AdminService;
import org.csu.mypetstore.service.CatelogService;
import org.csu.mypetstore.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("org.csu.mypetstore.persistence")
class MypetstoreApplicationTests {


    @Autowired
    AdminService adminService;
    @Autowired
    CatelogService catelogService;
    @Autowired
    AccountService accountService;


    @Test
    void contextLoads() {
    }

    @Test
    void ServiceTest(){
//        List<String>  list = accountMapper.getAccountList();
//       int b;
        System.out.println(accountService.getAccount("123"));

    }

}
