package com.app.helpchef.Model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersTest {

    @Test
    public void testEmailHasAt() {
        Users users = new Users();
        users.setEmail("test@gmail.com");

        assertTrue(users.getEmail().contains("@"));
    }

}