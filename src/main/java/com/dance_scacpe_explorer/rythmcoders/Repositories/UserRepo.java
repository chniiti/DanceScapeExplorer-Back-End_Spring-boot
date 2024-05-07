package com.dance_scacpe_explorer.rythmcoders.Repositories;


import com.dance_scacpe_explorer.rythmcoders.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
   Optional<User> findByFirstNameAndAndLastName(String Firstname , String Lastname);
}
