package com.example.restaurantmanagementapp.restaurant.repository;

import com.example.restaurantmanagementapp.restaurant.entity.Restaurant;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    @NotFound(action = NotFoundAction.IGNORE)
    Restaurant findByOid (String oid);

    @NotFound(action = NotFoundAction.IGNORE)
    Restaurant findByName (String name);
}
