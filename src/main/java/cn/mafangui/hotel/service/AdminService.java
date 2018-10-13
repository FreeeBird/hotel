package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin login(Admin admin);
    int register(Admin admin);
    Admin selectByUserName(String userName);
    int updateProfile(Admin admin);
    List<Admin> findAll();
}
