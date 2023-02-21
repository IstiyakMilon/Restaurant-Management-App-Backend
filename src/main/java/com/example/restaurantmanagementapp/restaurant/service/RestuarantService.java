package com.example.restaurantmanagementapp.restaurant.service;

import com.example.restaurantmanagementapp.restaurant.dto.RestaurantDto;
import com.example.restaurantmanagementapp.restaurant.entity.Restaurant;
import com.example.restaurantmanagementapp.restaurant.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RestuarantService {

    private final Logger log = LoggerFactory.getLogger(RestuarantService.class);

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant saveRestaurant(RestaurantDto restaurantDto){
        log.debug("Request to save Restaurant : {}", restaurantDto);
        String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantDto, restaurant);
        restaurant.setCreatedBy(user);
        restaurant.setCreatedOn(new Timestamp(new Date().getTime()));
        restaurant = restaurantRepository.save(restaurant);
        return  restaurant;
    }

    public Restaurant updateRestaurant(RestaurantDto restaurantDto, String oid) {
        log.debug("Request to update Restaurant : {}", restaurantDto);
        String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantDto, restaurant);
        restaurant.setUpdatedBy(user);
        restaurant.setUpdatedOn(new Timestamp(new Date().getTime()));
        restaurant = restaurantRepository.save(restaurant);
        return  restaurant;
    }

    @Transactional(readOnly = true)
    public Page<Restaurant> findAll(Pageable pageable) {
        log.debug("Request to get all Restaurant with offset and limit");
        return restaurantRepository.findAll(pageable);
    }

    public List<Restaurant> findAll() {
        log.debug("Request to get all Restaurant");
        return restaurantRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Restaurant findOne(String oid) {
        log.debug("Request to get Restaurant : {}", oid);
        return restaurantRepository.findByOid(oid);
    }

    public void delete(String oid) {
        log.debug("Request to delete Restaurant : {}", oid);
        restaurantRepository.deleteById(oid);
    }

}
