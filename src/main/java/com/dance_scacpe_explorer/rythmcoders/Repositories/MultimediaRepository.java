package com.dance_scacpe_explorer.rythmcoders.Repositories;

import com.dance_scacpe_explorer.rythmcoders.Entities.Competition;
import com.dance_scacpe_explorer.rythmcoders.Entities.Multimedia;
import com.dance_scacpe_explorer.rythmcoders.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {
}
