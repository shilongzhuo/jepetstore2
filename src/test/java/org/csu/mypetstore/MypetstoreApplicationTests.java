package org.csu.mypetstore;

import org.csu.mypetstore.domain.Category;
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

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
//        Category c = catelogService.getCategory("birds");
//        System.out.println(c.getDescription());
//        catelogService.getProductListByCategory("BIRDS");
//        catelogService.getInventoryQuantity("EST-1");
        catelogService.getCategoryList();
    }

}
