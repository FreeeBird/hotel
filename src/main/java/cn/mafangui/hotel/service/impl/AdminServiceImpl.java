package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.Admin;
import cn.mafangui.hotel.mapper.AdminMapper;
import cn.mafangui.hotel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        return adminMapper.selectByUserNameAndPassword(admin);
    }

    @Override
    public int register(Admin admin) {
        return adminMapper.insertSelective(admin);
    }

    @Override
    public Admin selectByUserName(String userName) {
        return adminMapper.selectByUserName(userName);
    }

    @Override
    public int updateProfile(Admin admin) {
        return adminMapper.updateByUserNameSelective(admin);
    }

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }
}
