package com.brunch.kaltz.junittest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @DisplayName("회원 가입 성공")
    @MockitoSettings(strictness = Strictness.WARN)
    @Test
    void signUpSuccess() throws Exception {
        //given
        SignUpRequest request = signUpRequest();
        UserResponse response = userResponse();

        doReturn(response).when(userService)
                .signUp(any(SignUpRequest.class));
    }

    private SignUpRequest signUpRequest() {
        return SignUpRequest.builder()
                .email("test@test.test")
                .pw("test")
                .build();
    }

    private UserResponse userResponse() {
        return UserResponse.builder()
                .email("test@test.test")
                .pw("test")
                .build();
    }
}















