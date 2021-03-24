package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.CategoryMapper;
import org.csu.mypetstore.persistence.ItemMapper;
import org.csu.mypetstore.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CatelogService {

    //大类
    @Autowired
    private CategoryMapper categoryMapper;

    public Category getCategory(String categoryId){
        return categoryMapper.getCategory(categoryId);
    }

    public List<Category> getCategoryList(){
        return categoryMapper.getCategoryList();
    }

    //小类
    @Autowired
    private ProductMapper productMapper;

    public List<Product> getProductListByCategory(String productId){
        return productMapper.getProductListByCategory(productId);
    }

    public Product getProduct(String productId){
        return productMapper.getProduct(productId);
    }

    //商品
    @Autowired
    private ItemMapper itemMapper;

    public int getInventoryQuantity(String itemId){
        return itemMapper.getInventoryQuantity(itemId);
    }

    public List<Item> getItemListByProduct(String productID){
        return itemMapper.getItemListByProduct(productID);
    }

    public Item getItem(String itemID){
        return itemMapper.getItem(itemID);
    }

    public void updateInventoryQuantity(Map<String,Object> param){
        itemMapper.updateInventoryQuantity(param);
    }

}
