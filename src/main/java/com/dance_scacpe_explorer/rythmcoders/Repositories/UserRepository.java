package com.dance_scacpe_explorer.rythmcoders.Repositories;

import com.dance_scacpe_explorer.rythmcoders.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
