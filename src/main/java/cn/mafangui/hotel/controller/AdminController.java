package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Admin;
import cn.mafangui.hotel.service.AdminService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public int login(String userName, String password){
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setPassword(password);
        if (adminService.login(admin) == null){
            return -1;
        }
        return 0;
    }

    /**
     * 注册
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
    public List<Admin> getAllAdmin(){
        return adminService.findAll();
    }
}
