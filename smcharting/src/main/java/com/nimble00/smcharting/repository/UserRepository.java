package com.nimble00.smcharting.repository;

import com.nimble00.smcharting.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { // CrudRepository<User, Long> {

//    @Query("SELECT u FROM User u WHERE u.username = :username")
//    public User findUserByUsername(@Param("username") String username);
    public User findUserByUsername(String username);

}