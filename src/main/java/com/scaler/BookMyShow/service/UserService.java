package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.exception.InvalidPasswordException;
import com.scaler.BookMyShow.exception.UserAlreadyExistException;
import com.scaler.BookMyShow.exception.UserNotFouncException;
import com.scaler.BookMyShow.model.User;
import com.scaler.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password){

        /*matches(CharSequence rawPassword, String encodedPassword)
          Verify the encoded password obtained from storage matches
          the submitted raw password after it too is encoded.*/

        User savedUser = userRepository.findByEmail(email);
        if(savedUser == null){
            throw new UserNotFouncException("User Not Found!");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, savedUser.getPassword())){
            return savedUser;
        }
        throw new InvalidPasswordException("Password doesn't match, please try again!");
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User signUp(String name, String email, String password){
        User newUser = userRepository.findByName(name);
        if(newUser != null){
            throw new UserAlreadyExistException("User "+name+" already exists!");
        }
        /*
        * save user -> name, email & password
        * encrypt password
        *
        * */

        newUser = new User(name, email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        newUser.setPassword(encoder.encode(password));

        newUser.setTickets(new ArrayList<>());

        userRepository.save(newUser);
        return newUser;
    }
}
