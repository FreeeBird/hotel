package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public int login(String username,String password){
        if(workerService.login(username,password) != null )
            return 1;
        else return 0;
    }
}
