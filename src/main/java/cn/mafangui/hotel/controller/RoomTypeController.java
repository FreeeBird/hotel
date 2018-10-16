package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.RoomType;
import cn.mafangui.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @RequestMapping(value = "/add")
    public int addNewType(int roomType,String typeName,double bookingPrice,double bookingDiscount){
        RoomType rt = new RoomType(roomType,typeName,bookingPrice,bookingDiscount);
        return roomTypeService.addRoomType(rt);
    }

    public int delType(int roomType,String typeName){
        return 0;
    }

}
