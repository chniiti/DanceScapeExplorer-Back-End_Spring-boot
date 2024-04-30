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
public class ForumPost implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private String title;
    private String content;
    private LocalDate postDate;

    @OneToMany( cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    private User author;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<React> reacts ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Comment comment;
}
