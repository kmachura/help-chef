package com.app.helpchef.Model;

import com.app.helpchef.Repository.UsersRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UsersEntityRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void injectedComponentsAreNotNull() {
        Assertions.assertNotNull(dataSource);
        Assertions.assertNotNull(jdbcTemplate);
        Assertions.assertNotNull(entityManager);
        Assertions.assertNotNull(usersRepository);
    }

    @Test
    public void creatUsersOneExample_thenFindByName() {
        usersRepository.save(new Users(1L, "john@doe.com", "John", "Doe", "JayD"));
        Users users = usersRepository.findByName("John");
        Assertions.assertNotNull(users);
        Assertions.assertEquals(users.getSurname(), "Doe");
    }

}
