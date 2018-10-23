package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.Room;
import cn.mafangui.hotel.service.RoomService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomServiceImplTest {
    Room room = new Room();
    @Autowired
    RoomService roomService;
    @Before
    public void setUp() throws Exception {
        room.setRoomId(4);
        room.setRoomNumber("102");
        room.setRoomFloor(1);
        room.setRoomDiscount(10.0);
        room.setRoomPrice(119.0);
        room.setRoomStatus("已预订");
        room.setRoomType(1);
        room.setTypeName("单人房");
    }

    @Test
    public void addRoom() {
        Assert.assertEquals(1, roomService.addRoom(room));
    }

    @Test
    public void deleteRoom() {
        Assert.assertEquals(1, roomService.deleteRoom(1));
    }

    @Test
    public void deleteRoom1() {
        Assert.assertEquals(1, roomService.deleteRoom("100"));
    }

    @Test
    public void updateRoom() {
        Assert.assertEquals(1, roomService.updateRoom(room));
    }

    @Test
    public void findById() {
        Assert.assertEquals("102", roomService.findById(4).getRoomNumber());
    }

    @Test
    public void findByNumber() {
        Assert.assertEquals("单人房", roomService.findByNumber("102").getTypeName());
    }

    @Test
    public void findByStatus() {
        Assert.assertTrue(!roomService.findByStatus("空闲").isEmpty());
    }

    @Test
    public void findByType() {
        Assert.assertTrue(!roomService.findByType("单人房").isEmpty());
    }

    @Test
    public void findAll() {
        Assert.assertTrue(roomService.findAll().size() == 3);
    }
}