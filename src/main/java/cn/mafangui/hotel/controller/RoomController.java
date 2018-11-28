package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Room;
import cn.mafangui.hotel.entity.RoomType;
import cn.mafangui.hotel.service.RoomService;
import cn.mafangui.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomTypeService roomTypeService;

    @RequestMapping(value = "/add")
    public int addRoom(String roomNumber,int typeId,String roomType,double roomPrice,double roomDiscount,int roomStatus,String remark){
        Room room = new Room(roomNumber,typeId,roomType,roomPrice,roomDiscount,roomStatus,remark);
        RoomType rt = new RoomType();
        if (roomService.insert(room) == 1){
            rt.setTypeId(typeId);
            rt.setRest(roomTypeService.selectById(typeId).getRest() + 1);
            return roomTypeService.update(rt);
        }else return 0;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/delete")
    public int deleteRoom(int roomId){
        return roomService.delete(roomId);
    }

    @RequestMapping(value = "/update")
    public int updateRoom(int roomId,String roomNumber,int typeId,
                          String roomType,double roomPrice,double roomDiscount,int roomStatus,String remark){
        Room room = new Room(roomNumber,typeId,roomType,roomPrice,roomDiscount,roomStatus,remark);
        room.setRoomId(roomId);
        return roomService.update(room);
    }

    @RequestMapping(value = "/withId")
    public Room getById(int roomId){
        return roomService.selectById(roomId);
    }

    @RequestMapping(value = "/withType")
    public List<Room> getByType(int typeId){
        return roomService.selectByType(typeId);
    }

    @RequestMapping(value = "/withStatus")
    public List<Room> getByStatus(int roomStatus){
        return roomService.selectByStatus(roomStatus);
    }

    @RequestMapping(value = "/all")
    public List<Room> getAll(){
        return roomService.selectAll();
    }


    @RequestMapping(value = "/typeRest")
    public int countTypeRest(){
        return 0;
    }
}
