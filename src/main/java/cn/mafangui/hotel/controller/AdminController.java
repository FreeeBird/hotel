package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Room;
import cn.mafangui.hotel.entity.RoomType;
import cn.mafangui.hotel.service.RoomService;
import cn.mafangui.hotel.service.RoomTypeService;
import cn.mafangui.hotel.service.WorkerService;
import cn.mafangui.hotel.utils.StaticString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private RoomService roomService;


    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public int login(String username,String password){
        if(workerService.login(username,password, StaticString.ADMIN) != null)
            return 1;
        else return 0;
    }





}
