package com.app.trade.repository;

import com.app.trade.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Gireesh
 * Created Date: 28-03-2019
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    long count();
}
