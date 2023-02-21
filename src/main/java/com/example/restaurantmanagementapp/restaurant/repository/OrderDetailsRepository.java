package com.example.restaurantmanagementapp.restaurant.repository;

import com.example.restaurantmanagementapp.restaurant.entity.OrderDetails;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {

    @NotFound(action = NotFoundAction.IGNORE)
    OrderDetails findByOid (String oid);

    @NotFound(action = NotFoundAction.IGNORE)
    List<OrderDetails> findByOrderOid (String orderOid);
}
