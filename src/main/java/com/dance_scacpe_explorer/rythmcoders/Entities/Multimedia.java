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

<<<<<<< HEAD
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
=======
    private Long mulitimediaId;
    @Temporal(TemporalType.DATE)
    private Date uploadDate;
    @Enumerated(EnumType.STRING)
    private FileType fileType;
>>>>>>> a76815504846741dde9236c2de3f36cddf9c96a6

    @ManyToOne(cascade = CascadeType.ALL)
    private Competition competition;
}
