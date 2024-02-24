package com.dance_scacpe_explorer.rythmcoders.Entities;

import com.dance_scacpe_explorer.rythmcoders.Entities.Enumarations.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Date birthday;
    @NonNull
    @Email
    private String email;
    @NonNull
    private String password;
    @NonNull
    private Integer phoneNumber;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "user")
    private List<ForumPost> forumPosts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ChatRoom> chatRooms;
<<<<<<< Updated upstream

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
=======
    @ManyToMany
>>>>>>> Stashed changes
    private  List<DanceSchool> danceSchools;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Ticket> tickets;

    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "users")
    private List<Result> resultats;

<<<<<<< Updated upstream
    @OneToOne
    private Competition competition;
=======
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> Roles;

>>>>>>> Stashed changes
}
