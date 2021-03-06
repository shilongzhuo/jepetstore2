package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ItemMapper {

    void updateInventoryQuantity(Map<String,Object> param);

    int getInventoryQuantity(String itemId);

    List<Item> getItemListByProduct(String productID);

    Item getItem(String itemID);

    void insertItem(Item item);

    void updateItem(Item item);

    void delItemByItemId(String itemId);

    void delItemByProductId(String productId);
}
