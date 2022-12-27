package com.fernando.oliveira.user.controller;

import com.fernando.oliveira.user.domain.entity.User;
import com.fernando.oliveira.user.domain.mapper.UserMapper;
import com.fernando.oliveira.user.domain.response.UserDetailResponse;
import com.fernando.oliveira.user.domain.response.UserRoleResponse;
import com.fernando.oliveira.user.mother.UserMother;
import com.fernando.oliveira.user.service.UserService;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    private static final String BASE_MAPPING = "/users";

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    private UserController controller;

    @MockBean
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void shouldReturnUserById() throws Exception {

        User userSaved = UserMother.getUser();
        UserDetailResponse response = UserMother.getUserDetailResponse(userSaved);
        UUID uuid = UUID.randomUUID();

        when(userService.findById(any(UUID.class))).thenReturn(userSaved);
        when(userMapper.entityToResponse(userSaved)).thenReturn(response);

        mockMvc.perform(get(BASE_MAPPING +"/"+uuid.toString())
                        .header("Content-Type", ContentType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("username"))
                .andExpect(jsonPath("$.email").value("email.teste@teste.com")) ;

    }

    @Test
    public void shouldLoadUserByUsername() throws Exception {

        User userSaved = UserMother.getUser();
        UserRoleResponse response = UserMother.getUserRoleResponse(userSaved);
        String username = "email.teste@teste.com";

        when(userService.loadUserByUsername(anyString())).thenReturn(userSaved);
        when(userMapper.entityToUserRoleResponse(userSaved)).thenReturn(response);

        mockMvc.perform(get(BASE_MAPPING +"/loadUserByUsername?username="+username)
                        .header("Content-Type", ContentType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("username"))
                .andExpect(jsonPath("$.email").value("email.teste@teste.com"))
                .andExpect(jsonPath("$.password").value("$2a$10$J4sjtoR2684kJ7eN8hhfv.oQMi3jsGrKI5fMB/wD3hErfYjLLvxLa"))
                .andExpect(jsonPath("$.roles[0].roleName").value("ADMIN"));

    }
}
