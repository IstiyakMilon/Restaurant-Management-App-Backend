package com.example.restaurantmanagementapp.jwt.service;


import com.example.restaurantmanagementapp.jwt.dao.RoleDao;
import com.example.restaurantmanagementapp.jwt.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
