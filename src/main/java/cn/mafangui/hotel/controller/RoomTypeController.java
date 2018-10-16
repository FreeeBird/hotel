package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.RoomType;
import cn.mafangui.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public int addNewType(int roomType,String typeName,double bookingPrice,double bookingDiscount){
        RoomType rt = new RoomType(roomType,typeName,bookingPrice,bookingDiscount);
        return roomTypeService.addRoomType(rt);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/del")
    public int delType(int roomType,String typeName){
        RoomType rt = new RoomType();
        rt.setRoomType(roomType);
        rt.setTypeName(typeName);
        return roomTypeService.delRoomType(rt);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public int updateType(int roomType,String typeName,double bookingPrice,double bookingDiscount){
        RoomType rt = new RoomType(roomType,typeName,bookingPrice,bookingDiscount);
        return roomTypeService.updateRoomType(rt);
    }

    @RequestMapping(value = "/query")
    public RoomType findByRoomType(int roomType){
        RoomType rt = new RoomType();
        rt.setRoomType(roomType);
        return roomTypeService.selectByName(rt);
    }

    @RequestMapping(value = "/all")
    public List<RoomType> findAllRoomType(){
        return roomTypeService.findAllType();
    }
}
