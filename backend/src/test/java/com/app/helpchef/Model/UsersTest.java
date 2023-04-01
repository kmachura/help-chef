package com.app.helpchef.Model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersTest {

    @Test
    public void testEmailHasAt() {
        Users user = new Users();
        user.setEmail("test@gmail.com");

        assertTrue(user.getEmail().contains("@"));
    }

    @Test
    public void testNameAndSurnameStartsWithCapitalLetter() {
        Users user = new Users();
        user.setName("TestName");
        user.setSurname("TestSurname");

        String userName =  user.getName();
        String userSurname = user.getSurname();

        boolean result = Character.isUpperCase(userName.charAt(0)) && Character.isUpperCase(userSurname.charAt(0));

        assertTrue(result);
    }

}