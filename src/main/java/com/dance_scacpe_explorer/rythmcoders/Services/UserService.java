package com.dance_scacpe_explorer.rythmcoders.Services;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dance_scacpe_explorer.rythmcoders.Entities.User;
import com.dance_scacpe_explorer.rythmcoders.Exceptions.UserException;
import com.dance_scacpe_explorer.rythmcoders.Repositories.UserRepository;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public User addUser(User user)  {
        User UserExist = userRepository.findByEmail(user.getEmail());
        if (UserExist!= null){
            throw new UserException("User already exist");
        }
        User newUser = new User();
        newUser.setUserId(user.getUserId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setBirthday(user.getBirthday());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(newUser);

    }
    //find all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    ///find by id
    public User getUserById(Long userId){
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                return userOptional.get();
            } else {
                throw new UserException("User not found with id: " + userId);
            }
    }
    public Boolean deleteUser(Long userId){
        Optional<User> userOptional2 = userRepository.findById(userId);
        if (userOptional2.isPresent()){
            userRepository.deleteById(userId);
            return true;
        } else {
            return false;
        }
    }



}