package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Room;
import cn.mafangui.hotel.utils.MyDateTimeFormat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomControllerTest {
    @Autowired
    private RoomController roomController;

    MyDateTimeFormat df = new MyDateTimeFormat();

    Room room = new Room();
    @Before
    public void setUp() throws Exception {
        room.setRoomNumber("502");
    }

    @Test
    public void addRoom() {
    }

    @Test
    public void deleteRoom() {
    }

    @Test
    public void updateRoom() {
    }

    @Test
    public void allRoom() {
    }

    @Test
    public void findRoomByNumber() {

    }

    @Test
    public void findRoomByStatus() {
    }

    @Test
    public void findRoomByType() {
    }
}