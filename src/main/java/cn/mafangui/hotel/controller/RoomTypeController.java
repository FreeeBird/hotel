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


    @RequestMapping(value = "/all")
    public List<RoomType> getAllRoomType(){
        return roomTypeService.findAllType();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public int addRoomType(String roomType,Double price,Double discount,int area,
                           int bedNum,String bedSize,int window,String remark){
        RoomType rt = new RoomType(roomType,remark,price,discount,area,bedNum,bedSize,window);
        int result = 0;
        result = roomTypeService.insert(rt);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public int updateRoomType(int typeId,String roomType,Double price,Double discount,int area,
                           int bedNum,String bedSize,int window,String remark){
        RoomType rt = new RoomType(roomType,remark,price,discount,area,bedNum,bedSize,window);
        rt.setTypeId(typeId);
        int result = 0;
        result = roomTypeService.update(rt);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/delete")
    public int deleteRoomType(int typeId){
        int result = 0;
        result = roomTypeService.delete(typeId);
        return result;
    }

}
