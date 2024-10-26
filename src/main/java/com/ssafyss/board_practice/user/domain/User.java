package com.ssafyss.board_practice.user.domain;

public class User {
    int id;
    String oauthId;
    String oauthType;
    String email;
    String password;
    String profileImage;
    String deletedAt;
    boolean delete;

    public User(int id, String oauthId, String oauthType, String email, String password, String profileImage,
                String deletedAt, boolean delete) {
        this.id = id;
        this.oauthId = oauthId;
        this.oauthType = oauthType;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
        this.deletedAt = deletedAt;
        this.delete = delete;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOauthId() {
        return oauthId;
    }

    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    public String getOauthType() {
        return oauthType;
    }

    public void setOauthType(String oauthType) {
        this.oauthType = oauthType;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
