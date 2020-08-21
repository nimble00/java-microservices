package com.nimble00.userservice.services;

import com.nimble00.userservice.models.User;
import com.nimble00.userservice.models.UserRequestModel;
import com.nimble00.userservice.models.UserResponseModel;
import com.nimble00.userservice.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nimble00.userservice.exceptions.UserNotFoundException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
        modelMapper = new ModelMapper();
    }

    @Override
    @Transactional
    public UserResponseModel addUser(UserRequestModel userRequestModel) {
        String str = UUID.randomUUID().toString();
        userRequestModel.setId(str);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        User user = userRepo.save(mapper.map(userRequestModel,User.class));
        return mapper.map(user,UserResponseModel.class);
    }


    @Override
    @Transactional
    public List<UserResponseModel> getAllUsers() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<UserResponseModel>>(){}.getType();
        // Incoming list is getting converted to UserResponseModel JSON for response
        List<UserResponseModel> userList = modelMapper.map(userRepo.findAll(),listType);
        return userList;
    }

    @Override
    @Transactional
    public UserResponseModel findUserByName(String userName) throws UserNotFoundException {
        User user = userRepo.findByFullName(userName);
        if(user==null) {
            throw new UserNotFoundException("user " + userName + " not found");
        }
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(user, UserResponseModel.class);
    }

}