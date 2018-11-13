package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.RoomType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomTypeControllerTest {

    @Autowired
    RoomTypeController rtc;

    @Test
    public void getAllRoomType() {
        List<RoomType> result = rtc.getAllRoomType();
        System.out.println(result);
        Assert.assertEquals(2,result.size());
    }

    @Test
    public void addRoomType() {
        int res = 0;
        res = rtc.addRoomType("单人房",129.0,12.0,10,1,"1.2",0,"1 Person");
        Assert.assertEquals(1,res);
    }

    @Test
    public void updateRoomType() {
        int res = 0;
        res = rtc.updateRoomType(2,"单人房",109.0,22.0,10,1,"1.2",0,"1 Person");
        Assert.assertEquals(1,res);
    }

    @Test
    public void deleteRoomType() {
        int res = 0;
        res = rtc.deleteRoomType(1);
        Assert.assertEquals(1,res);
    }
}