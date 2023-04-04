package com.app.helpchef.Controller;

import com.app.helpchef.Model.Users;
import com.app.helpchef.Repository.UsersRepository;
import com.app.helpchef.Service.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersController.class)
class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsersRepository usersRepository;
    @MockBean
    private UsersService usersService;

    @Test
    public void shouldReturnUserFromService() throws Exception {
        Users users = new Users(1L, "john@doe.com", "John", "Doe", "JayD");

        when(usersService.createUser(users)).thenReturn(users);
        this.mockMvc.perform(get("/api/users/1L")).andDo(print()).andExpect(status().isOk());
    }

}
