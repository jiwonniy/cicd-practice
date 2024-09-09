package com.cicd.server.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "nickname", length = 30)
    private String nickname;

    @Column(name = "goal", length = 50)
    private String goal;

    @Builder
    public User(String nickname, String goal) {
        this.nickname = nickname;
        this.goal = goal;
    }
}
