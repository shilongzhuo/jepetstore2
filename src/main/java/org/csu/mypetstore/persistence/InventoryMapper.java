package org.csu.mypetstore.persistence;

import org.springframework.stereotype.Repository;

@Repository
public interface InventoryMapper {

    int getInventoryByCategoryName(String categoryName);

    int getSoldOutNumByByCategoryName(String categoryName);

    int getUnsoldNumByCategoryName(String categoryName);

    int getOrderedNumByCategoryName(String categoryName);

    void placeAnOrder();


}
