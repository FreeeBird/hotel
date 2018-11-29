package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.Room;
import cn.mafangui.hotel.enums.RoomStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomMapperTest {

    @Autowired
    private RoomMapper rm;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selectByType() {
    }

    @Test
    public void selectByStatus() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void randomSelectByTypeAndStatus() {
        System.out.println(RoomStatus.AVAILABLE.getCode());
        System.out.println(RoomStatus.AVAILABLE.getStatus());
        System.out.println(rm.randomSelectByTypeAndStatus(2, RoomStatus.AVAILABLE.getCode()));
    }
}
