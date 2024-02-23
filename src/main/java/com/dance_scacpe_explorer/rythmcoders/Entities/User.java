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
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "author")
    private List<ForumPost> forumPosts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creator")
    private List<ChatRoom> chatRooms;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "dsUsers")
    private  List<DanceSchool> danceSchools;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    private List<Ticket> tickets;

    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "resUsers")
    private List<Result> resultats;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "userCompetition")
   private List<Competition> competitions;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "userRole")
    @JoinTable(
            name = "user_userrole",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "userrole_id")
    )
    private List<UserRole> userRoles;

}
