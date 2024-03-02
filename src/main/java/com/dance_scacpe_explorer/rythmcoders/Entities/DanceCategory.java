package com.dance_scacpe_explorer.rythmcoders.Entities;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;





@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DanceCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "danceCategory", cascade = CascadeType.ALL)
    private List<DanceStyle> danceStyles;

    @ManyToOne(cascade = CascadeType.ALL)
    private Competition competition;

}
