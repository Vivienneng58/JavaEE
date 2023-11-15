package edu.whu;

import edu.whu.entity.User;
import edu.whu.entity.UserDto;
import edu.whu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void addUser(){
//        User user=new User();
//        user.setId("user4");
//        user.setPassword("abc");
//        userService.addUser(user);


        UserDto userdto = userService.getUser("user1");
        assertNotNull(userdto);
        assertTrue(new BCryptPasswordEncoder().matches("abc",userdto.getPassword()));



    }
}
