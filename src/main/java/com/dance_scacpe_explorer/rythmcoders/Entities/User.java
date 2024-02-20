package com.dance_scacpe_explorer.rythmcoders.Entities;

import com.dance_scacpe_explorer.rythmcoders.Entities.Enumarations.Role;
import jakarta.persistence.*;
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
    private Integer userId;
    private Role role;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Date birthday;
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private Integer phoneNumber;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "user")
    private List<ForumPost> forumPosts;

    @OneToMany(cascade = CascadeType.ALL )
    private List<ChatRoom> chatRooms;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private  List<DanceSchool> danceSchools;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Ticket> tickets;

    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "users")
    private List<Result> resultats;

    @OneToOne
    private Competition competition;
}
