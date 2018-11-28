package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Worker;
import cn.mafangui.hotel.enums.Role;
import cn.mafangui.hotel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

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
        if(workerService.login(username,password, Role.ADMIN.getValue()) != null)
            return 1;
        else return 0;
    }

    /**
     * 管理员注册
     * @param username
     * @param password
     * @param name
     * @param gender
     * @param phone
     * @param email
     * @param address
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public int register(String username,String password,String name,String gender,String phone,String email,String address){
        Worker worker = new Worker(username,password,name,gender,phone,email,address);
        worker.setRole(Role.ADMIN.getValue());
        return workerService.insert(worker);
    }

    /**
     * 根据 username查找
     * @param username
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/withUsername")
    public Worker getByUsername(String username) {
        Worker res = workerService.selectByUsername(username);
        res.setPassword(null);
        return res;
    }




}
