package com.ssafyss.board_practice.domain.user.entity;

import java.sql.Timestamp;
import lombok.Builder;

@Builder
public class User {
    private Long id;
    private String oauthId;
    private String oauthType;
    private String email;
    private String password;
    private String profileImage;
    private Timestamp createdAt;
    private Timestamp deletedAt;
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public boolean emailMatches(String email) {
        return this.email.equals(email);
    }
}
