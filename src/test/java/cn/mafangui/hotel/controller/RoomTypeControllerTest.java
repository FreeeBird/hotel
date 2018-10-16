package cn.mafangui.hotel.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoomTypeControllerTest {

    @Autowired
    private RoomTypeController roomTypeController;

    @Test
    public void addNewType() {
    }

    @Test
    public void delType() {
    }

    @Test
    public void updateType() {
    }

    @Test
    public void findByRoomType() {
        int roomType = 101;
        Assert.assertNotNull(roomTypeController.findByRoomType(roomType));
    }

    @Test
    public void findAllRoomType() {
        Assert.assertNotNull(roomTypeController.findAllRoomType());
    }
}