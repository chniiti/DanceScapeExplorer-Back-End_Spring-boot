package com.dance_scacpe_explorer.rythmcoders.Entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
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

    private Date birthday;
    @NonNull
    @Email
    private String email;
    @NonNull
    private String password;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;

    private Integer phoneNumber;
    ///////
    @OneToMany(cascade= CascadeType.ALL, mappedBy = "author")
    private List<ForumPost> forumPosts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creator")
    private List<ChatRoom> chatRooms;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "dsUsers")
    private  List<DanceSchool> danceSchools;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "buyer")
    private Ticket ticket;

    @OneToMany (mappedBy = "competitor",cascade = CascadeType.ALL)
    private List<Competition> competitions;

    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "resUsers")
    private List<Result> results;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> Roles;


}
