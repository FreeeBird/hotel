package cn.mafangui.hotel.controller;


import cn.mafangui.hotel.entity.User;
import cn.mafangui.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/updateProfile")
    public int updateProfile(String userName, String password, String name,
                              String phone, String email, String address, String idNumber){
        User user = new User(userName,password,name,phone,email,address,idNumber);
        return userService.updateProfile(user);
    }
    /**
     * 注册
     * @param userName
     * @param password
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param idNumber
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public int userRegister(String userName, String password, String name,
                            String phone, String email, String address, String idNumber){
        User user = new User(userName,password,name,phone,email,address,idNumber);
        return userService.register(user);
    }
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public int userLogin(String userName, String password){
        if (userService.login(userName,password) == null){
            return -1;
        }
        return 1;
    }
    /**
     * 查看用户资料
     * @param userName
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getProfile")
    public User getProfile(String userName){
        return userService.selectByUserName(userName);
    }

}
