package com.example.restaurantmanagementapp.jwt.service;


import com.example.restaurantmanagementapp.jwt.repository.RoleRepository;
import com.example.restaurantmanagementapp.jwt.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
