package com.brunch.kaltz.junittest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public UserResponse signUp(SignUpRequest request) {
        return new UserResponse();
    }

    public List<UserResponse> findAll() {
        return new ArrayList<>();
    }
}
