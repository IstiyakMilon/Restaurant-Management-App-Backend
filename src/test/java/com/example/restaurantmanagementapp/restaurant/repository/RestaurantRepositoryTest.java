package com.example.restaurantmanagementapp.restaurant.repository;

import com.example.restaurantmanagementapp.restaurant.entity.Restaurant;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository restaurantRepository;

    Restaurant rest = Restaurant.builder()
            .name("Bishmillah Hotel")
            .description("Bishmillah Hotel")
            .address("Dhaka")
            .locationJson("Dhaka")
            .status("Active")
            .createdOn(Timestamp.valueOf(LocalDateTime.now())).build();

    @Test
    void saveRestaurantTest(){
        Restaurant restaurant = restaurantRepository.save(rest);
        Assert.assertNotNull(restaurant);
        Assert.assertNotNull(restaurant.getOid());
        Assert.assertEquals("Bishmillah Hotel", restaurant.getName());
    }


    @Test
    void findByOid() {
    }

    @Test
    void findByName() {
    }
}