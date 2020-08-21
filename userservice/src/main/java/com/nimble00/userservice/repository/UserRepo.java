package com.nimble00.userservice.repository;

import com.nimble00.userservice.models.User;
import com.nimble00.userservice.models.UserResponseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByFullName(String userName);
}