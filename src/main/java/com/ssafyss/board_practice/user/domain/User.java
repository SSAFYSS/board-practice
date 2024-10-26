package com.ssafyss.board_practice.user.domain;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String oauthId;
    private String oauthType;
    private String email;
    private String password;
    private String profileImage;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private boolean deleted;

    public User(String oauthId, String oauthType, String email, String password, String profileImage) {
        this.oauthId = oauthId;
        this.oauthType = oauthType;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
        this.deleted = false;
    }

    public Long getId() {
        return id;
    }

    public String getOauthId() {
        return oauthId;
    }

    public String getOauthType() {
        return oauthType;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", oauthId='" + oauthId + '\'' +
                ", oauthType='" + oauthType + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                ", deleted=" + deleted +
                '}';
    }
}
