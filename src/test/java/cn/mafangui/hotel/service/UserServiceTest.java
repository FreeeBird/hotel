package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.User;
import cn.mafangui.hotel.utils.RandomCreation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void insertUser() {
        User user = new User();
        for (int i = 0; i < 30; i++) {
            Map m = RandomCreation.getAddress();
            user.setName((String) m.get("name"));
            user.setUsername((String) m.get("username"));
            user.setPassword((String) m.get("password"));
            user.setGender((String) m.get("gender"));
            user.setPhone((String) m.get("phone"));
            user.setAddress((String) m.get("road"));
            user.setEmail((String) m.get("email"));
            user.setIdcard((String) m.get("idcard"));
            userService.insertUser(user);
        }
    }
}
