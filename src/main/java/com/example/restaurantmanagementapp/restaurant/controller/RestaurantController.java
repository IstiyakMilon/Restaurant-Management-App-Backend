package com.example.restaurantmanagementapp.restaurant.controller;


import com.example.restaurantmanagementapp.restaurant.dto.RestaurantDto;
import com.example.restaurantmanagementapp.restaurant.entity.Restaurant;
import com.example.restaurantmanagementapp.restaurant.service.RestaurantService;
import com.example.restaurantmanagementapp.util.ExceptionHandlerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/restaurant")
public class RestaurantController {
    private final Logger log = LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping()
    public ResponseEntity<Restaurant> createAsset(
            @Valid @RequestBody RestaurantDto restaurantDto
    ) {
        try{
            log.debug("REST request to save Restaurant : {}", restaurantDto);
            Restaurant restaurant = restaurantService.saveRestaurant(restaurantDto);
            log.info("Response send for Restaurant save: {}", restaurant);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } catch (ExceptionHandlerUtil ex) {
            log.error(ex.getMessage(), ex);
            throw new ResponseStatusException(ex.getCode(), ex.getMessage(), ex);
        }
    }
}
