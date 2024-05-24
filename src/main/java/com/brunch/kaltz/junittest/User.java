package com.brunch.kaltz.junittest;

public class User {

    private String email;
    private String pw;
    private String role;

    public User(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }

    public User(String email, String pw, String role) {
        this.email = email;
        this.pw = pw;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }
}
