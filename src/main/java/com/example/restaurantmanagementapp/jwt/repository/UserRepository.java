package com.example.restaurantmanagementapp.jwt.repository;


import com.example.restaurantmanagementapp.jwt.entity.User;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @NotFound(action = NotFoundAction.IGNORE)
    User findByOid (String oid);

    @NotFound(action = NotFoundAction.IGNORE)
    User findByUserName (String userName);
}
