package cn.mafangui.hotel.controller;


import cn.mafangui.hotel.entity.Room;
import cn.mafangui.hotel.service.RoomService;
import cn.mafangui.hotel.utils.finalString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/roomInfo")
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
    @RequestMapping(value = "/add")
    public HashMap addRoom(String roomNumber, int roomFloor, int roomType, String typeName, double roomPrice,double roomDiscount,String roomStatus){
        HashMap result = new HashMap();
        int data = 0;
        Room room = new Room(roomNumber,roomFloor,roomType,typeName,roomPrice,roomDiscount,roomStatus);
        try {
            data = roomService.addRoom(room);
        }catch (Exception e){
            data = -1;
        }
        result.put(finalString.CODE,20000);
        result.put(finalString.DATA,data);
        return result;
    }

    /**
     * 根据房间id或者房间号码删除房间
     * @param roomId
     * @param roomNumber
     * @return
     */
    @RequestMapping(value = "/delete")
    public HashMap deleteRoom(int roomId,String roomNumber){
        HashMap result = new HashMap();
        int data = 0;
        try {
            if (roomNumber == null || "".equals(roomNumber)){
                data = roomService.deleteRoom(roomId);
            }else {
                data = roomService.deleteRoom(roomNumber);
            }
        }catch (Exception e){
            data = -1;
        }
        result.put(finalString.CODE,20000);
        result.put(finalString.DATA,data);
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
    @RequestMapping(value = "/update")
    public HashMap updateRoom(int roomId,String roomNumber, int roomFloor, int roomType, String typeName, double roomPrice,double roomDiscount,String roomStatus){
        HashMap result = new HashMap();
        int data = 0;
        Room room = new Room(roomNumber,roomFloor,roomType,typeName,roomPrice,roomDiscount,roomStatus);
        room.setRoomId(roomId);
        try {
            data = roomService.updateRoom(room);
        }catch (Exception e){
            data = -1;
        }
        result.put(finalString.CODE,20000);
        result.put(finalString.DATA,data);
        return result;
    }

    /**
     * 查询所有房间
     * @return
     */
    @RequestMapping(value = "/all")
    public HashMap allRoom(){
        HashMap result = new HashMap();
        result.put(finalString.DATA,roomService.findAll());
        result.put(finalString.CODE,20000);
        return result;
    }

    /**
     * 根据id
     * 查询房间信息
     * @param roomId
     * @return
     */
    @RequestMapping(value = "/withId")
    public HashMap findRoomById(int roomId){
        HashMap result = new HashMap();
        result.put(finalString.CODE,20000);
        try{
            result.put(finalString.DATA,roomService.findById(roomId));
        }catch (Exception e){
            result.put(finalString.DATA,-1);
        }
        return result;
    }

    /**
     * 根据房号查询房间信息
     * @param roomNumber
     * @return
     */
    @RequestMapping(value = "/withRoomNumber")
    public HashMap findRoomByNumber(String roomNumber){
        HashMap result = new HashMap();
        result.put(finalString.CODE,20000);
        try{
            result.put(finalString.DATA,roomService.findByNumber(roomNumber));
        }catch (Exception e){
            result.put(finalString.DATA,-1);
        }
        return result;
    }

    /**
     * 根据状态查询房间信息
     * @param roomStatus
     * @return
     */
    @RequestMapping(value = "/withStatus")
    public HashMap findRoomByStatus(String roomStatus){
        HashMap result = new HashMap();
        result.put(finalString.CODE,20000);
        try{
            result.put(finalString.DATA,roomService.findByStatus(roomStatus));
        }catch (Exception e){
            result.put(finalString.DATA,-1);
        }
        return result;
    }

    /**
     * 根据类型查询房间信息
     * @param typeName
     * @return
     */
    @RequestMapping(value = "/withType")
    public HashMap findRoomByType(String typeName){
        HashMap result = new HashMap();
        result.put(finalString.CODE,20000);
        try{
            result.put(finalString.DATA,roomService.findByType(typeName));
        }catch (Exception e){
            result.put(finalString.DATA,-1);
        }
        return result;
    }
}
