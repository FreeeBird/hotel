package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.RoomType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomTypeServiceImplTest {
    @Autowired
    RoomTypeServiceImpl roomTypeService;

    @Test
    public void insert() {
        String typeName = "big";
        double price = 123;
        double discount = 12;
        int area = 10;
        int bedNum = 1;
        String bedSize = "15*12";
        int window = 0;
        RoomType roomType = new RoomType();
        roomType.setArea(area);
        roomType.setBedNum(bedNum);
        roomType.setBedSize(bedSize);
        roomType.setDiscount(discount);
        roomType.setPrice(price);
        roomType.setRoomType(typeName);
        roomType.setWindow(window);
        Assert.assertEquals(1,roomTypeService.insert(roomType));
    }

    @Test
    public void delete() {
        int id = 1;
        Assert.assertEquals(1,roomTypeService.delete(id));
    }

    @Test
    public void update() {
        RoomType rt =roomTypeService.selectById(2);
        rt.setRest(rt.getRest() -1);
        System.out.println(rt);
        System.out.println(roomTypeService.update(rt));
    }

    @Test
    public void selectByName() {
        String typeName = "single";
        int id = roomTypeService.selectByName(typeName).getTypeId();
        System.out.println(roomTypeService.selectByName(typeName));
        Assert.assertEquals(1,id);
    }

    @Test
    public void selectById() {
        int id  = 1;
        String typeName = roomTypeService.selectById(id).getRoomType();
        System.out.println(roomTypeService.selectById(id));
        Assert.assertEquals("single",typeName);
    }

    @Test
    public void findAllType() {
        System.out.println(roomTypeService.findAllType());
        Assert.assertNotNull(roomTypeService.findAllType());
    }
}
