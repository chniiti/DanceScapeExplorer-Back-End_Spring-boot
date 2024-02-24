package com.dance_scacpe_explorer.rythmcoders.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ChatRoom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private String roomName;

    @ManyToOne
    private User user;


    @OneToMany
    private List<ChatMessage> chatMessages  = new ArrayList<>();

}
