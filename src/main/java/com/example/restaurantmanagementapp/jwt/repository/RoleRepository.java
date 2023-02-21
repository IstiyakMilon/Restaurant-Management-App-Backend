package com.example.restaurantmanagementapp.jwt.repository;


import com.example.restaurantmanagementapp.jwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
