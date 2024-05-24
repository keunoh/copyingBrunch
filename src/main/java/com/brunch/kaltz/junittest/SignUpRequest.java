package com.brunch.kaltz.junittest;

public class SignUpRequest {

    // 1번
    private String email;
    private String pw;

    // 2번
    public SignUpRequest email(String email) {
        this.email = email;
        return this;
    }

    public SignUpRequest pw(String pw) {
        this.pw = pw;
        return this;
    }

    public static SignUpRequest builder() {
        return new SignUpRequest();
    }

    public SignUpRequest build() {
        return this;
    }
}
