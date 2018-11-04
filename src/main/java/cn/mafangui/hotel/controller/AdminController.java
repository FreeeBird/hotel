package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Admin;
import cn.mafangui.hotel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public HashMap login(String username, String password){
        HashMap result = new HashMap();
        Admin admin = new Admin();
        admin.setUserName(username);
        admin.setPassword(password);
        System.out.println(admin);
        if (adminService.selectByUserName(username) == null){
            result.put("data","用户名不存在!");
        }else if (adminService.login(admin) == null){
            result.put("data","用户名或密码不正确!");
        }else {
            result.put("data","登录成功!");
        }
        result.put("code",20000);
        result.put("token","admin");
        return result;
    }

    @RequestMapping(value = "/logout")
    public HashMap logout(String token) {
        HashMap result = new HashMap();
        result.put("code",20000);
        result.put("data",token);
        return result;
    }

    @RequestMapping(value = "/info")
    public HashMap info(String token, String username) {
        HashMap result = new HashMap();
        HashMap data = new HashMap();
        Admin admin = adminService.selectByUserName(username);
        if (admin == null){
            data.put("data","用户名不存在!");
        }else {
            data.put("data",admin);
        }
        result.put("code",20000);
        String[] roles = {"admin"};
        data.put("roles",roles);
        result.put("data",data);
        return result;
    }

    /**
     * 管理员注册
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public int register(String userName, String password){
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setPassword(password);
        return adminService.register(admin);
    }

    /**
     * 更新资料
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/updateProfile")
    public int updateProfile(String userName, String password){
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setPassword(password);
        return adminService.updateProfile(admin);
    }

    /**
     * 更改密码
     * @param userName
     * @param password
     * @param newPassword
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updatePassword")
    public int updatePassword(String userName, String password,String newPassword){
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setPassword(password);
        return adminService.updatePassword(admin,newPassword);
    }

    /**
     * 查找管理员
     * @param userName
     * @return
     */
    @RequestMapping(value = "/getAdmin")
    public Admin getAdmin(String userName){
        return adminService.selectByUserName(userName);
    }

    /**
     * 查找所有管理员
     * @return
     */
    @RequestMapping(value = "/getAllAdmin")
    public HashMap getAllAdmin(){
        HashMap result = new HashMap();
        result.put("code",1);
        result.put("data",adminService.findAll());
        return result;
    }
}
