package cn.mafangui.hotel.service;


import cn.mafangui.hotel.entity.User;

import java.util.List;

public interface UserService {

    User selectById(int id);

    int register(User user);

    User login(String userName, String password);

    User selectByUserName(String userName);

//    int count();
//
//    List<User> findAll();
//
//    int updateProfile(User user);

}
