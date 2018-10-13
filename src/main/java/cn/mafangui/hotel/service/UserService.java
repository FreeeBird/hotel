package cn.mafangui.hotel.service;


import cn.mafangui.hotel.entity.User;

public interface UserService {

    User selectById(int id);

    int register(User user);

    User login(String userName, String password);

    User selectByUserName(String userName);

    int updateProfile(User user);
}
