package com.dance_scacpe_explorer.rythmcoders.Entities;



import com.dance_scacpe_explorer.rythmcoders.Entities.Enumarations.FileType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Multimedia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_multimedia;
    private String name;
    private String videoUrl;
    private String videoId;

    public Multimedia(String name, String videoUrl, String videoId){
        this.name=name;
        this.videoUrl=videoUrl;
        this.videoId=videoId;
    }

    @Enumerated(EnumType.STRING)
        private FileType fileType;

    @ManyToOne(cascade = CascadeType.ALL)
    private Competition competition;
}
