package com.dance_scacpe_explorer.rythmcoders.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    private String content;
    private LocalDate postDate;


    @OneToMany(cascade = CascadeType.ALL)
    private List<ReactComment> reactComments = new ArrayList<>();




    @ManyToOne
    private ForumPost forumPost ;
}
