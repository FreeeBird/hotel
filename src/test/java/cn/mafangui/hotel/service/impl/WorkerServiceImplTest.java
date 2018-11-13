package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkerServiceImplTest {

    @Autowired
    WorkerServiceImpl workerService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void insert() {
        String role = "operator";
        String username = "abc";
        String password = "abc";
        String name = "fdsa";
        String gender = "女";
        String phone = "242424";
        Worker worker = new Worker();
        worker.setPhone(phone);
        worker.setGender(gender);
        worker.setName(name);
        worker.setPassword(password);
        worker.setUsername(username);
        worker.setRole(role);
        Assert.assertEquals(1,workerService.insert(worker));
    }

    @Test
    public void delete() {
        int id = 4;
        Assert.assertEquals(1,workerService.delete(id));
    }

    @Test
    public void updateById() {
        int id = 4;
        String role = "operator";
        String username = "abc";
        String password = "abc";
        String name = "fdsa";
        String gender = "女";
        String phone = "11111111";
        Worker worker = new Worker();
        worker.setWorkerId(4);
        worker.setPhone(phone);
        worker.setGender(gender);
        worker.setName(name);
        worker.setPassword(password);
        worker.setUsername(username);
        worker.setRole(role);
        Assert.assertEquals(1,workerService.updateById(worker));
    }

    @Test
    public void selectById() {
        int id = 4;
        Assert.assertEquals("fdsa",workerService.selectById(id).getName());
    }

    @Test
    public void findAll() {
        List<Worker> list = workerService.findAll();
        System.out.println(list);
        Assert.assertNotNull(list);
    }

    @Test
    public void selectByRole() {
        String role = "admin";
        List<Worker> list = workerService.selectByRole(role);
        System.out.println(list);
        Assert.assertEquals(1,list.size());
    }

    @Test
    public void login() {
        String username = "admin";
        String password = "admin";
        Worker worker = workerService.login(username,password,"admin");
        Assert.assertNotNull(worker);
    }
}