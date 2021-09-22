package com.example.demodb.repository;

import com.example.demodb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Eduard Ivanov on 7/1/21
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.name from User u where u.id = :id")
    String getUserName(@Param("id") long id);
}
