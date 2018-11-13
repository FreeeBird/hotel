package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    @Autowired
    UserController uc;

    @Test
    public void userLogin() {
        Assert.assertEquals(1,uc.userLogin("nihao","123456"));
    }

    @Test
    public void userRegister() {
        int res = uc.userRegister("hi","hi","海","男","1123","132","ddd","123");
        Assert.assertEquals(1,res);
    }

    @Test
    public void userUpdate() {
        Assert.assertEquals(1,uc.userUpdate(3,null,null,null,null,"add",null));
    }

    @Test
    public void updatePassword() {
        Assert.assertEquals(1,uc.updatePassword("hi","hi","123"));
    }

    @Test
    public void getAllUser() {
        Assert.assertEquals(2,uc.getAllUser().size());
    }

    @Test
    public void isUsernameExist() {
        Assert.assertEquals(0,uc.isUsernameExist("addd"));
    }
}