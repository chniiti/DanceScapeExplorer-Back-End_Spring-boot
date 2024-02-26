package com.dance_scacpe_explorer.rythmcoders.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.security.SecureRandomParameters;
import java.time.LocalDate;

@Getter
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SousComment implements SecureRandomParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scommentId;
    private String content;
    private LocalDate commentDate;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment parentComment;
}
