package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Room;
import cn.mafangui.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/all")
    public List<Room> getAllRoom(){
        List<Room> result = roomService.selectAll();
        for (Room r:result) {
        }
        return result;
    }
}
