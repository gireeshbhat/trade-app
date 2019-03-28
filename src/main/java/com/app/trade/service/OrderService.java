package com.app.trade.service;


import com.app.trade.model.OrderItem;

import java.util.List;

/**
 * Author: Gireesh
 * Created Date: 28-03-2019
 */
public interface OrderService {

    long totalCount();

    List<OrderItem>  getAll();

    OrderItem saveItem(OrderItem item);
}
