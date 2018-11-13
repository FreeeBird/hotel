package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.User;
import cn.mafangui.hotel.service.UserService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void selectById() {
        String res = userService.selectById(1).getPassword();
        Assert.assertEquals("aaa",res);
    }

    @Test
    public void insertUser() {
        User user = new User("nihao","nihao","你好","女",
                "18749834","1239@w.c","street2.02d","123213213");
        int res = userService.insertUser(user);
        Assert.assertEquals(1,res);
    }

    @Test
    public void deleteUser() {
        Assert.assertEquals(1,userService.deleteUser(1));
    }

    @Test
    public void updateUser() {
        User user = new User("nihao","123456","你好","女",
                "18749834","1239@w.c","street2.02d","123213213");
        user.setUserId(2);
        int res = userService.updateUser(user);
        Assert.assertEquals(1,res);
    }

    @Test
    public void selectByUsernameAndPassword() {
        int res = userService.selectByUsernameAndPassword("nihao","123456").getUserId();
        Assert.assertEquals(2,res);

    }

    @Test
    public void selectByUsername() {
        int res = userService.selectByUsername("nihao").getUserId();
        Assert.assertEquals(2,res);
    }

    @Test
    public void selectAll() {
        int res = userService.selectAll().size();
        Assert.assertEquals(1,res);
    }
}