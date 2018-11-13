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

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public int userLogin(String username,String password){
        int result = 0;
        if (userService.selectByUsernameAndPassword(username,password) != null){
            result = 1;
        }
        else result = 0;
        return result;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public int userRegister(String username,String password,String name,String gender,String phone,String email,String address,String idcard){
        User user = new User(username,password,name,gender,phone,email,address,idcard);
        return userService.insertUser(user);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public int userUpdate(int userId,String name,String gender,String phone,String email,String address,String idcard){
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setGender(gender);
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddress(address);
        user.setIdcard(idcard);
        return userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/updatePassword")
    public int updatePassword(String username,String oldPassword,String newPassword){
        User user = userService.selectByUsernameAndPassword(username,oldPassword);
        if (user == null){
            return -1;
        }else {
            user.setPassword(newPassword);
            return userService.updateUser(user);
        }
    }

    @RequestMapping(value = "/all")
    public List<User> getAllUser(){
        return userService.selectAll();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/isUsernameExist")
    public int isUsernameExist(String username){
        int result = 0;
        if (userService.selectByUsername(username) != null){
            result = 1;
        }
        else result = 0;
        return result;
    }

}
