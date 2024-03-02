package com.dance_scacpe_explorer.rythmcoders.Entities;

import com.dance_scacpe_explorer.rythmcoders.Entities.Enumarations.Role;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long UserRoleId;
    @Enumerated(EnumType.STRING)
    private Role roleUser;

    @ManyToMany(mappedBy = "userRoles")
    private List<User> users;
}
