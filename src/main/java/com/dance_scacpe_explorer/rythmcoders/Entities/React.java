package com.dance_scacpe_explorer.rythmcoders.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class React implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reactId;
    private boolean liked;
    private boolean dislike;
    private LocalDate dateReact;



    @ManyToOne(cascade = CascadeType.ALL)
    private ForumPost postForumPost;
}
