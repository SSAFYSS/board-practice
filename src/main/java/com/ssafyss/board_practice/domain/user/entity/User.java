package com.ssafyss.board_practice.domain.user.entity;

import java.sql.Timestamp;

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
}
