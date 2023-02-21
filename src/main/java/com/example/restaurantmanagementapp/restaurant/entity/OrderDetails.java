package com.example.restaurantmanagementapp.restaurant.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "oid")
    private String oid;

    @Column(name = "order_oid")
    private String orderOid;

    @Column(name = "menu_oid")
    private String menuOid;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "total_serving")
    private Double totalServing;

    @Column(name = "total_amount")
    private Double totalAmount;

}
