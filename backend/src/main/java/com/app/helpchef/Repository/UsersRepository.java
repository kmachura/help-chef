package com.app.helpchef.Repository;

import com.app.helpchef.Model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByName(String name);
}
