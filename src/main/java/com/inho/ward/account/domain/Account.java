package com.inho.ward.account.domain;

import com.inho.ward.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String puuid;

    @Column(nullable = false)
    private String gameName;

    @Column(nullable = false)
    private String tagLine;

    @OneToOne
    private User user;
}
