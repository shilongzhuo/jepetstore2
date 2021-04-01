package org.csu.mypetstore;

import org.csu.mypetstore.common.EmailUtil;
import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.persistence.CartItemMapper;
import org.csu.mypetstore.persistence.VerificationMapper;
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
    VerificationService verificationService;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
       verificationService.delVerificationCodeByUsername("1843773386gyk");
    }

}
