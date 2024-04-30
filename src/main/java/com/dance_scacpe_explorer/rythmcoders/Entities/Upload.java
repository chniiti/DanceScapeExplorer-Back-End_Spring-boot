package com.dance_scacpe_explorer.rythmcoders.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Upload implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long videoId;
    private String path;
    @Column(name = "upload_date")
    private LocalDateTime uploadDate;

}
