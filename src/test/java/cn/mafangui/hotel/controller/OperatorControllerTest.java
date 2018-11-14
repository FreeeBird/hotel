package cn.mafangui.hotel.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OperatorControllerTest {
    @Autowired
    OperatorController oc;

    @Test
    public void login() {
        Assert.assertEquals(1,oc.login("w1","w1"));
    }

    @Test
    public void deleteOperator() {
        Assert.assertEquals(1,oc.deleteOperator(2));
    }

    @Test
    public void getAllOperator() {
        Assert.assertEquals(1,oc.getAllOperator().size());
    }

    @Test
    public void getOperator() {
        Assert.assertNotNull(oc.getOperator(2));
    }

    @Test
    public void addOperator() {
        int res = oc.addOperator("op","op","杜锋","男","124342","assf","jfad");
        Assert.assertEquals(1,res);
    }

    @Test
    public void updateOperator() {
        int res = oc.updateOperator(3,"疾风","女","32132","asdsa","assf");
        Assert.assertEquals(1,res);
    }
}