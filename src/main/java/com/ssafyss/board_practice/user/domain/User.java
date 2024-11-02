package com.ssafyss.board_practice.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String oauthId;

    private String oauthType;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String profileImage;

    @Column(nullable = false)
    private boolean deleted = false;

    @Builder
    public User(String oauthId, String oauthType, String email, String password, String profileImage) {
        this.oauthId = oauthId;
        this.oauthType = oauthType;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
    }
}
