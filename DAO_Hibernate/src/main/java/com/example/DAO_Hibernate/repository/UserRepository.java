package com.example.DAO_Hibernate.repository;

import com.example.DAO_Hibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCity(String city);
}
