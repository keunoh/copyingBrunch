package com.brunch.kaltz.junittest;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public UserResponse signUp(SignUpRequest request) {
        return new UserResponse();
    }

    public List<UserResponse> findAll() {
        return new ArrayList<>();
    }
}
