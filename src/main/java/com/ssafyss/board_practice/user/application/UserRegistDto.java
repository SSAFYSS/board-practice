package com.ssafyss.board_practice.user.application;

public class UserRegistDto {

    private String email;
    private String password;
    private String profileImage;

    public UserRegistDto(String email, String password, String profileImage) {
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
