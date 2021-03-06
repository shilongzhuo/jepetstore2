package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {

     List<Product> getProductListByCategory(String categoryId);

     Product getProduct(String productId);

     List<Product> searchProductList(String keywords);

     void insertProduct(Product product);

     void updateProduct(Product product);

     void delProductByProductId(String productId);

     void delProductByCategoryId(String categoryId);

     List<Product> getAllProducts();
}
