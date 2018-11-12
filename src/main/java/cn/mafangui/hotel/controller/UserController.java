package cn.mafangui.hotel.controller;


import cn.mafangui.hotel.entity.User;
import cn.mafangui.hotel.service.UserService;
import cn.mafangui.hotel.utils.StaticString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 更新资料
     * @param username
     * @param password
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param idcard
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updateProfile")
    public int updateProfile(String username, String password, String name,String gender,
                              String phone, String email, String address, String idcard){
        User user = new User(username,password,name,gender,phone,email,address,idcard);
        return userService.updateProfile(user);
    }


    public HashMap updatePassword(String username, String oldPassword, String newPassword){
        HashMap response = new HashMap();
        if (userService.login(username,oldPassword) == null){
            response.put(StaticString.CODE,200);
            response.put(StaticString.STATUS,"密码错误");
        }else {
            User user = new User();
            user.setPassword(newPassword);
            int result = userService.updateProfile(user);
            response.put(StaticString.DATA,result);
        }
        return response;
    }

    /**
     *
     * @param username
     * @param password
     * @param name
     * @param gender
     * @param phone
     * @param email
     * @param address
     * @param idcard
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public HashMap userRegister(String username, String password, String name,String gender,
                                String phone, String email, String address, String idcard){
        HashMap response = new HashMap();
        User user = new User(username,password,name,phone,gender,email,address,idcard);
        response.put(StaticString.CODE,200);
        response.put(StaticString.DATA,userService.register(user));
        return response;
    }
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public HashMap userLogin(String username, String password){
        HashMap response = new HashMap();
        response.put(StaticString.CODE,200);
        response.put(StaticString.DATA,userService.login(username,password));
        return response;
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
