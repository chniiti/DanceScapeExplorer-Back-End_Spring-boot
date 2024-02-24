package com.dance_scacpe_explorer.rythmcoders.Controller;

import com.dance_scacpe_explorer.rythmcoders.Entities.User;
import com.dance_scacpe_explorer.rythmcoders.Exceptions.UserException;
import com.dance_scacpe_explorer.rythmcoders.Services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;


import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/addUser")
    public ResponseEntity addUserResponse(@RequestBody User user){
     try {
         User addUser = userService.addUser(user);
         return new ResponseEntity<>(addUser, HttpStatus.CREATED);

     } catch (UserException e){
         logger.error("Error adding user: {}", e.getMessage());
         return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
     }
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/getUserById/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        if (userService.deleteUser(userId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // Handle not found case
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
