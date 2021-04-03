package org.csu.mypetstore;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatelogService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("org.csu.mypetstore.persistence")
class MypetstoreApplicationTests {

    @Autowired
    CatelogService catelogService;

    @Autowired
    AccountService accountService;
    @Test
    void contextLoads() {
    }

    @Test
    void ServiceTest(){
//        Category c = catelogService.getCategory("birds");
//        System.out.println(c.getDescription());
        Account a = accountService.getAccount("ACID");
        System.out.println(a.getUsername()+","+a.getEmail()+","+a.getFirstName()+","+a.getLastName()+","+a.getStatus()
                +","+a.getAddress1()+","+a.getAddress2()+","+a.getCity()+","+a.getState()+","+a.getZip()+","+a.getCountry()+","+a.getPhone());

    }

}
