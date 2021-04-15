package org.csu.mypetstore.service;

import org.csu.mypetstore.persistence.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryMapper inventoryMapper;

    public int getInventoryNum(String categoryName) {return inventoryMapper.getInventoryByCategoryName(categoryName);}

    public int getSoldOutNumByByCategoryName(String categoryName) {return inventoryMapper.getSoldOutNumByByCategoryName(categoryName);}

    public int getUnsoldNumByCategoryName(String categoryName) {return inventoryMapper.getUnsoldNumByCategoryName(categoryName);}

    public int getOrderedNumByCategoryName(String categoryName) {return inventoryMapper.getOrderedNumByCategoryName(categoryName);}
}
