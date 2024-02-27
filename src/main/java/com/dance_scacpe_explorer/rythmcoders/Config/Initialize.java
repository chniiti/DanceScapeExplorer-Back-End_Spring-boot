package com.dance_scacpe_explorer.rythmcoders.Config;

import com.dance_scacpe_explorer.rythmcoders.Entities.Role;
import com.dance_scacpe_explorer.rythmcoders.Entities.User;
import com.dance_scacpe_explorer.rythmcoders.Repositories.RoleRepository;

import com.dance_scacpe_explorer.rythmcoders.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class Initialize implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception{

        Role adminRole = roleRepository.findByRoleName("admin");
        if (adminRole == null){
            adminRole = new Role ("admin");
            roleRepository.save(adminRole);
            User adminUser = userRepository.findByEmail("admin@admin.com");
            if (adminUser == null){
                adminUser = new User();
                adminUser.setFirstName("admin");
                adminUser.setLastName("admin");
                adminUser.setEmail("admin@admin.com");
                adminUser.setPassword("admin");
                userRepository.save(adminUser);
                affecterUserToRole(adminUser.getUserId(), adminRole.getRoleId());
            }

        }


    }
    public void affecterUserToRole(Long userId, long roleId) {
        Role role = roleRepository.findById(roleId).get();
        User user = userRepository.findById(userId).get();
        user.getRoles().add(role);
        userRepository.save(user);
    }
}
