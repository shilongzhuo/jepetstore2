package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.persistence.LineItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    //订单中的商品
    @Autowired
    private LineItemMapper lineItemMapper;
}
