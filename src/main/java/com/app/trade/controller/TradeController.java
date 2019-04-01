package com.app.trade.controller;

import com.app.trade.constant.AppConstant;
import com.app.trade.model.OrderItem;
import com.app.trade.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Gireesh
 * Created Date: 28-03-2019
 */
@RestController
@RequestMapping("/trades")
public class TradeController {

    @Autowired
    private OrderService orderService;


    /*
     * End Point 1 Stores the given data in H2 database
     * @param OrderItem
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderItem saveItem(@RequestBody OrderItem item) {
        return orderService.saveItem(item);
    }


    /*
     * End Point 2 Returns the various informations of the stored order
     * @param
     * */
    @GetMapping(value = "/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> orderSummary() {
        Map<String, String> ordeDetails = new HashMap<>();
        StringBuilder combOrderDetails = new StringBuilder();

        long totalCount = orderService.totalCount();
        Map details = orderService.findAveragePriceAndTotalQuantity();
        List<Map> orderCombined = orderService.findCombinableOrders();

        Integer avgPrice = (Integer) details.get("AvgPrice");
        BigInteger totalQty = (BigInteger) details.get("TotalQty");

        for (Map order : orderCombined) {
            String temp = "(" + order.get("side") + " + " + order.get("security") + " + " + order.get("fundName") + ")";
            combOrderDetails = combOrderDetails.length() > 0 ? combOrderDetails.append(", ").append(temp) : combOrderDetails.append(orderCombined.size()).append(temp);
        }

        ordeDetails.put("total-count", String.valueOf(totalCount));
        ordeDetails.put("average-price", String.valueOf((avgPrice)));
        ordeDetails.put("total-quantity", String.valueOf(totalQty));
        ordeDetails.put("combinable-orders", combOrderDetails.toString());

        return ordeDetails;
    }


    /*
     * End Point 3 Returns the list of Orders of specified type and value of same type.
     * @param type
     * @param value
     * */
    @GetMapping(value = "/summary/{type}/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderItem> getSummaryBySubject(@PathVariable(name = "type") String type, @PathVariable(name = "value") String value) {
        if (AppConstant.App.SECURITY.equalsIgnoreCase(type)) {
            return orderService.findBySecurity(value);
        } else if (AppConstant.App.FUND.equalsIgnoreCase(type)) {
            return orderService.findByFundName(value);
        }
        return new ArrayList<>();
    }
}
