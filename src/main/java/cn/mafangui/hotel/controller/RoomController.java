package cn.mafangui.hotel.controller;


import cn.mafangui.hotel.entity.Room;
import cn.mafangui.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.PrinterException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "roomInfo")
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * 增加房间
     * @param roomNumber
     * @param roomFloor
     * @param roomType
     * @param typeName
     * @param roomPrice
     * @param roomDiscount
     * @param roomStatus
     * @return
     */
    @RequestMapping(value = "add")
    public int addRoom(String roomNumber, int roomFloor, int roomType, String typeName, double roomPrice,double roomDiscount,String roomStatus){
        int result = 0;
        Room room = new Room(roomNumber,roomFloor,roomType,typeName,roomPrice,roomDiscount,roomStatus);
        try {
            result = roomService.addRoom(room);
        }catch (Exception e){
            result = -1;
        }
        return result;
    }

    /**
     * 根据房间id或者房间号码删除房间
     * @param roomId
     * @param roomNumber
     * @return
     */
    @RequestMapping(value = "delete")
    public int deleteRoom(int roomId,String roomNumber){
        int result = 0;
        try {
            if (roomNumber == null || "".equals(roomNumber)){
                result = roomService.deleteRoom(roomId);
            }else {
                result = roomService.deleteRoom(roomNumber);
            }
        }catch (Exception e){
            result = -1;
        }
        return result;
    }

    /**
     * 更改房间信息
     * @param roomId
     * @param roomNumber
     * @param roomFloor
     * @param roomType
     * @param typeName
     * @param roomPrice
     * @param roomDiscount
     * @param roomStatus
     * @return
     */
    @RequestMapping(value = "update")
    public int updateRoom(int roomId,String roomNumber, int roomFloor, int roomType, String typeName, double roomPrice,double roomDiscount,String roomStatus){
        int result = 0;
        Room room = new Room(roomNumber,roomFloor,roomType,typeName,roomPrice,roomDiscount,roomStatus);
        room.setRoomId(roomId);
        try {
            result = roomService.updateRoom(room);
        }catch (Exception e){
            result = -1;
        }
        return result;
    }

    /**
     * 查询所有房间
     * @return
     */
    @RequestMapping(value = "/all")
    public HashMap allRoom(){
        HashMap result = new HashMap();
        result.put("data",roomService.findAll());
        result.put("code",20000);
        return result;
    }

    /**
     * 根据状态查询房间信息
     * @param roomNumber
     * @return
     */
    @RequestMapping(value = "/withRoomNumber")
    public Room findRoomByNumber(String roomNumber){
        try{
            return roomService.findByNumber(roomNumber);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 根据状态查询房间信息
     * @param roomStatus
     * @return
     */
    @RequestMapping(value = "/withStatus")
    public List<Room> findRoomByStatus(String roomStatus){
        try{
            return roomService.findByStatus(roomStatus);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 根据类型查询房间信息
     * @param typeName
     * @return
     */
    @RequestMapping(value = "/withType")
    public List<Room> findRoomByType(String typeName){
        try{
            return roomService.findByType(typeName);
        }catch (Exception e){
            return null;
        }
    }
}
