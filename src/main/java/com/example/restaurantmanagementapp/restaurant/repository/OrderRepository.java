package com.example.restaurantmanagementapp.restaurant.repository;

import com.example.restaurantmanagementapp.restaurant.entity.Order;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

    @NotFound(action = NotFoundAction.IGNORE)
    Order findByOid (String oid);

    @NotFound(action = NotFoundAction.IGNORE)
    List<Order> findByCustomerOid (String customerOid);

    @NotFound(action = NotFoundAction.IGNORE)
    List<Order> findByMenuOid (String menuOid);
}
