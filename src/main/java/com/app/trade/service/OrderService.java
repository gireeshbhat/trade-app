package com.app.trade.service;

import com.app.trade.model.OrderItem;

import java.util.List;
import java.util.Map;

/**
 * Author: Gireesh
 * Created Date: 28-03-2019
 */
public interface OrderService {

    OrderItem saveItem(OrderItem item);

    long totalCount();

    Map findAveragePriceAndTotalQuantity();

    List<Map> findCombinableOrders();

    List<OrderItem> findBySecurity(String security);

    List<OrderItem> findByFundName(String fundName);

}
