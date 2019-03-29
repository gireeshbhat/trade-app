package com.app.trade.repository;

import com.app.trade.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Author: Gireesh
 * Created Date: 28-03-2019
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    long count();

    @Query(value = "SELECT AVG(item.price) AS AvgPrice, SUM(item.quantity) AS TotalQty FROM OrderItem item", nativeQuery = true)
    Map findAveragePriceAndTotalQuantity();

    @Query(value = "SELECT item.side, item.security, item.fundName, COUNT(*) " +
            "FROM OrderItem item GROUP BY item.side, item.security, item.fundName HAVING COUNT(*) > 1", nativeQuery = true)
    List<Map> findCombinables();
}
