package com.app.trade.controller;

import com.app.trade.model.OrderItem;
import com.app.trade.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Gireesh
 * Created Date: 28-03-2019
 */
@RestController
@RequestMapping("/trades")
public class TradeController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/total-count")
    public long totalOrders(){
        return orderService.totalCount();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderItem> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/save")
    public Integer saveObj(){
        OrderItem item = new OrderItem();
        item.setSide("Buy");
        item.setSecurity("SDFHG");
        item.setFundName("ASFGFGFG");
        item.setQuantity(1200);
        item.setPrice(124885);

        item = orderService.saveItem(item);

        return item.getOrderId();
    }
}
