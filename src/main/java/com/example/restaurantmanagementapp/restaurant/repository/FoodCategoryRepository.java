package com.example.restaurantmanagementapp.restaurant.repository;

import com.example.restaurantmanagementapp.restaurant.entity.FoodCategory;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, String> {

    @NotFound(action = NotFoundAction.IGNORE)
    FoodCategory findByOid (String oid);

    @NotFound(action = NotFoundAction.IGNORE)
    FoodCategory findByName (String name);
}
