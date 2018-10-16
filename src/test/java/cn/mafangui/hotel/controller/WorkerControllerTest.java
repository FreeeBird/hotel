package cn.mafangui.hotel.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WorkerControllerTest {

    @Autowired
    private WorkerController workerController;

    @Test
    public void login() {
        String userName = "haha";
        String pwd = "123456";
        String password = "11111";
        Assert.assertEquals(1,workerController.login(userName,password));
    }

    @Test
    public void addWorker() {
        String userName = "haha";
        String password = "123456";
        String workerName = "nidsahao";
        String phone = "9834431";
        String email = "fads@kjd";
        String address = "street101";
        Assert.assertEquals(1,  workerController.addWorker(userName,password,workerName,phone,email,address));
    }

    @Test
    public void delWorker() {
        String userName = "haha";
        Assert.assertEquals(1, workerController.delWorker(userName));
    }

    @Test
    public void updateWorker() {
        String userName = "haha";
        String password = "11111";
        String workerName = "chenhao";
        String phone = null;
        String email = null;
        String address = null;
        Assert.assertEquals(1, workerController.updateWorker(userName,password,workerName,phone,email,address));
    }

    @Test
    public void queryWorker() {
        String userName = "haha";
        System.out.println(workerController.queryWorker(userName));
        Assert.assertNotNull(workerController.queryWorker(userName));
    }

    @Test
    public void findAllWorkers() {
        Assert.assertNotNull(workerController.findAllWorkers());
    }
}