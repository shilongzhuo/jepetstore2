package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.CategoryMapper;
import org.csu.mypetstore.persistence.ItemMapper;
import org.csu.mypetstore.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CatelogService {

    //大类
    @Autowired
    private CategoryMapper categoryMapper;
    //小类
    @Autowired
    private ProductMapper productMapper;
    //商品
    @Autowired
    private ItemMapper itemMapper;

    //大类的增删改查

    public Category getCategory(String categoryId){
        return categoryMapper.getCategory(categoryId);
    }

    public List<Category> getCategoryList(){ return categoryMapper.getCategoryList(); }

    @Transactional
    public void insertCategory(Category category){
       categoryMapper.insertCategory(category);
    }

    @Transactional
    public void updateCategory(Category category){
        categoryMapper.updateCategory(category);
    }

    @Transactional
    public void delCategoryByCategoryId(String categoryId){
        categoryMapper.delCategoryByCategoryId(categoryId);
        List<Product> productList = productMapper.getProductListByCategory(categoryId);
        for(int i=0;i<productList.size();i++){
            productMapper.delProductByProductId(productList.get(i).getProductId());
            itemMapper.delItemByProductId(productList.get(i).getProductId());
        }
    }

    //小类的增删改查

    public List<Product> getProductListByCategory(String productId){ return productMapper.getProductListByCategory(productId); }

    public Product getProduct(String productId){
        return productMapper.getProduct(productId);
    }

    public  List<Product> searchProductList(String keywords){
        return productMapper.searchProductList(keywords);
    }

    @Transactional
    public void insertProduct(Product product){
        productMapper.insertProduct(product);
    }

    @Transactional
    public void updateProduct(Product product){
        productMapper.updateProduct(product);
    }

    @Transactional
    public void delProductByProductId(String productId){
        productMapper.delProductByProductId(productId);
        itemMapper.delItemByProductId(productId);
    }

    //商品的增删改查

    public int getInventoryQuantity(String itemId){
        return itemMapper.getInventoryQuantity(itemId);
    }

    public List<Item> getItemListByProduct(String productID){
        List<Item> itemList = itemMapper.getItemListByProduct(productID);
        for(int i=0;i<itemList.size();i++){
            itemList.get(i).setProductId(itemList.get(i).getProduct().getProductId());
        }
        return itemList;
    }

    public Item getItem(String itemID){
        Item item = itemMapper.getItem(itemID);
        item.setProductId(item.getProduct().getProductId());
        return item;
    }

    @Transactional
    public void updateInventoryQuantity(Map<String,Object> param){
        itemMapper.updateInventoryQuantity(param);
    }

    @Transactional
    public void insertItem(Item item){
        itemMapper.insertItem(item);
    }

    @Transactional
    public void updateItem(Item item){
        itemMapper.updateItem(item);
    }

    @Transactional
    public void delItemByItemId(String itemId){
        itemMapper.delItemByItemId(itemId);
    }
}
