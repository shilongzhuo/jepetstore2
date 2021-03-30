package org.csu.mypetstore;

import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("org.csu.mypetstore.persistence")
class MypetstoreApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        Order order = orderService.getOrder(1000);

        order.setOrderId(1009);

        //orderService.insertOrder(order);

    }

}
