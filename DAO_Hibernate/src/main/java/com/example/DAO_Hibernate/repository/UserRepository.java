package com.example.DAO_Hibernate.repository;

import com.example.DAO_Hibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCity(String city);

    List<User> findByAgeLessThanOrderByAgeAsc(int age);

    Optional<User> findByNameAndSurname(String name, String surname);
}