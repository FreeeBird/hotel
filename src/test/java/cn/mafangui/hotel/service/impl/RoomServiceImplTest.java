package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.Room;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomServiceImplTest {

    @Autowired
    RoomServiceImpl roomService;

    @Test
    public void insert() {
        Room room = new Room();
        room.setRoomNumber("101");
        room.setRoomPrice(123.0);
        room.setRoomDiscount(12.1);
        room.setRoomStatus(0);
        room.setTypeId(1);
        room.setRoomType("ade");
        Assert.assertEquals(1,roomService.insert(room));
    }

    @Test
    public void delete() {
        Assert.assertEquals(1,roomService.delete(1));
    }

    @Test
    public void update() {
        Room room = new Room();
        room.setRoomId(1);
        room.setRoomNumber("222");
        room.setRoomPrice(123.0);
        room.setRoomDiscount(12.1);
        room.setRoomStatus(0);
        room.setTypeId(1);
        room.setRoomType("ade");
        Assert.assertEquals(1,roomService.update(room));
    }

    @Test
    public void selectById() {
        System.out.println(roomService.selectById(1));
        Assert.assertEquals("222",roomService.selectById(1).getRoomNumber());
    }

    @Test
    public void selectByStatus() {
        System.out.println(roomService.selectByStatus(0));
        Assert.assertEquals(1,roomService.selectByStatus(0).size());
    }

    @Test
    public void selectByType() {
        System.out.println(roomService.selectByType(1));
        Assert.assertEquals(1,roomService.selectByType(1).size());
    }

    @Test
    public void selectAll() {
        System.out.println(roomService.selectAll());
        Assert.assertEquals(1,roomService.selectAll().size());
    }
}