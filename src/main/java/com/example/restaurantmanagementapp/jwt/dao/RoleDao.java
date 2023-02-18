package com.example.restaurantmanagementapp.jwt.dao;


import com.example.restaurantmanagementapp.jwt.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
