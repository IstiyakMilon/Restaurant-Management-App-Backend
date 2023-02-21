package com.example.restaurantmanagementapp.restaurant.repository;


import com.example.restaurantmanagementapp.restaurant.entity.Menu;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

    @NotFound(action = NotFoundAction.IGNORE)
    Menu findByOid (String oid);

    @NotFound(action = NotFoundAction.IGNORE)
    Menu findByName (String name);
}
