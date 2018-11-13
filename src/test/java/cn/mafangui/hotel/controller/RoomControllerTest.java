package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Room;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomControllerTest {

    @Autowired
    RoomController rc;

    @Test
    public void addRoom() {

        Assert.assertEquals(1,rc.addRoom("100",2,"单人房",
                108.0,20.0,1,"1 person"));
    }

    @Test
    public void deleteRoom() {
        Assert.assertEquals(1,rc.deleteRoom(3));
    }

    @Test
    public void updateRoom() {
        Assert.assertEquals(1,rc.updateRoom(2,"200",2,"单人房",
                108.0,20.0,1,"1 person"));
    }

    @Test
    public void getById() {
        int res = rc.getById(2).getTypeId();
        Assert.assertEquals(2,res);
    }

    @Test
    public void getByType() {
        int res = rc.getByType(2).size();
        Assert.assertEquals(1,res);
    }

    @Test
    public void getByStatus() {
        int res = rc.getByStatus(1).size();
        Assert.assertEquals(2,res);
    }

    @Test
    public void getAll() {
        int res = rc.getAll().size();
        Assert.assertEquals(2,res);
    }
}