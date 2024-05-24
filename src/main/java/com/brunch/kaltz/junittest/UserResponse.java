package com.brunch.kaltz.junittest;

public class UserResponse {
    // 1번
    private String email;
    private String pw;
    private String role;

    // 2번
    public UserResponse email(String email) {
        this.email = email;
        return this;
    }

    public UserResponse pw(String pw) {
        this.pw = pw;
        return this;
    }

    public UserResponse role(String role) {
        this.role = role;
        return this;
    }

    public static UserResponse builder() {
        return new UserResponse();
    }

    public UserResponse build() {
        return this;
    }
}
