package com.nimble00.smcharting.services;

import com.nimble00.smcharting.models.MyUserDetails;
import com.nimble00.smcharting.models.User;
import com.nimble00.smcharting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.security.core.userdetails.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }


    @Transactional
    public User registerNewUserAccount(User userDto) throws UserAlreadyExistException {
        if (emailAlreadyExist(userDto.getUsername())) {
            throw new UserAlreadyExistException(
                    "There is an account with that email address: "
                            +  userDto.getUsername());
        }

        // the rest of the registration operation
    }
    private boolean emailAlreadyExist(String email) {
        return userRepository.findUserByUsername(email) != null;
    }
}
