package com.app.helpchef.Controller;

import com.app.helpchef.Model.Users;
import com.app.helpchef.Repository.UsersRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

@SpringBootTest
class SmokeTest {

    @Autowired
    private UsersController usersController;

    @Test
    public void injectedComponentsAreNotNull() {
        Assertions.assertNotNull(usersController);
    }

}
