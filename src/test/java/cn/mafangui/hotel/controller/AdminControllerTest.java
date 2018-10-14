package cn.mafangui.hotel.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdminControllerTest {
    @Autowired
    private AdminController adminController;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void login() {
        String userName = "admin";
        Assert.assertEquals(0, adminController.login(userName, userName));
    }

    @Test
    public void register() {
        String userName = "test";
        Assert.assertEquals(1, adminController.register(userName, userName));
    }

    @Test
    public void updateProfile() {
        String userName = "test";
        String password = "1234";
        Assert.assertEquals(1, adminController.updateProfile(userName, password));
    }

    @Test
    public void getAdmin() {
        String userName = "test";
        Assert.assertNotNull(adminController.getAdmin(userName));
    }

    @Test
    public void getAllAdmin() {
        Assert.assertNotNull(adminController.getAllAdmin());
    }
}