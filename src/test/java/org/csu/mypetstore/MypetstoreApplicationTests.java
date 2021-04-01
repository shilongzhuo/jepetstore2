package org.csu.mypetstore;

import org.csu.mypetstore.common.EmailUtil;
import org.csu.mypetstore.common.MD5Util;
import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.persistence.CartItemMapper;
import org.csu.mypetstore.persistence.VerificationMapper;
import org.csu.mypetstore.service.AdminService;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.OrderService;
import org.csu.mypetstore.service.VerificationService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

@SpringBootTest
@MapperScan("org.csu.mypetstore.persistence")
class MypetstoreApplicationTests {

    @Autowired
    AdminService adminService;

    @Test
    void contextLoads() {
    }

    @Test
    void test() throws Exception {
      adminService.insertAdmin("admin","123456");
      Admin admin = adminService.getAdmin("admin","123456");
      int a = 1;


    }

}
