package org.csu.mypetstore;

import org.csu.mypetstore.common.EmailUtil;
import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.persistence.CartItemMapper;
import org.csu.mypetstore.service.CartService;
import org.csu.mypetstore.service.OrderService;
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
    CartService cartService;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        try {
            EmailUtil.sendEmail("1843773386gyk@gmail.com","123456789");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

}
