package com.nimble00.userservice.services;

import com.nimble00.userservice.exceptions.UserNotFoundException;
import com.nimble00.userservice.models.UserRequestModel;
import com.nimble00.userservice.models.UserResponseModel;

import java.util.List;

public interface UserService {
    UserResponseModel addUser(UserRequestModel userRequestModel);
    List<UserResponseModel> getAllUsers();
    UserResponseModel findUserByName(String userId) throws UserNotFoundException;
}

