package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.RoomType;
import cn.mafangui.hotel.mapper.RoomTypeMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoomTypeServiceImplTest {

    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Test
    public void addRoomType() {
        RoomType roomType = new RoomType(201,"豪华大床房",229.00,20.0);
        Assert.assertEquals(1, roomTypeMapper.insertSelective(roomType));
    }

    @Test
    public void delRoomType() {
        RoomType roomType = new RoomType();
        roomType.setRoomType(201);
        Assert.assertEquals(1, roomTypeMapper.deleteByRoomType(roomType));
    }

    @Test
    public void updateRoomType() {
        RoomType roomType = new RoomType();
        roomType.setRoomType(103);
        roomType.setBookingDiscount(20.0);
        Assert.assertEquals(1,roomTypeMapper.updateByRoomTypeSelective(roomType));
    }

    @Test
    public void selectByName() {
        RoomType roomType = new RoomType();
        roomType.setRoomType(103);
        System.out.println(roomTypeMapper.selectByRoomType(roomType));
        Assert.assertNotNull(roomTypeMapper.selectByRoomType(roomType));
    }

    @Test
    public void findAllType() {
        System.out.println(roomTypeMapper.findAll());
        Assert.assertNotNull(roomTypeMapper.findAll());
    }
}