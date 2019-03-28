package com.app.trade.model;


import com.app.trade.constant.AppConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: Gireesh
 * Created Date: 28-03-2019
 */
@Entity
@Table(name = AppConstant.Dbo.ORDER_ITEM)
@ToString(doNotUseGetters = true)
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId", unique = true, nullable = false)
    @Getter
    @Setter
    private int orderId;

    @Column(name = "Side", nullable = false)
    @Getter
    @Setter
    private String side;

    @Column(name = "Security", nullable = false)
    @Getter
    @Setter
    private String security;

    @Column(name = "FundName", nullable = false)
    @Getter
    @Setter
    private String fundName;

    @Column(name = "Quantity", nullable = false)
    @Getter
    @Setter
    private Integer quantity;

    @Column(name = "Price", nullable = false)
    @Getter
    @Setter
    private Integer price;

}