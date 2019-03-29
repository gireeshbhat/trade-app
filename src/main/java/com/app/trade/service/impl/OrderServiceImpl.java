package com.app.trade.service.impl;

import com.app.trade.model.OrderItem;
import com.app.trade.repository.OrderItemRepository;
import com.app.trade.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: Gireesh
 * Created Date: 28-03-2019
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderItemRepository itemRepository;

    @Override
    public List<Map> findCombinableOrders() {
        return itemRepository.findCombinables();
    }

    @Override
    public OrderItem saveItem(OrderItem item) {
        return itemRepository.save(item);
    }

    @Override
    public long totalCount() {
        return itemRepository.count();
    }

    @Override
    public Map findAveragePriceAndTotalQuantity() {
        return itemRepository.findAveragePriceAndTotalQuantity();
    }
}
