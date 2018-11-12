package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.User;

import cn.mafangui.hotel.mapper.UserMapper;
import cn.mafangui.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int register(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User login(String username, String password) {
        return userMapper.selectByUsernameAndPassword(username,password);
    }

    @Override
    public User selectByUserName(String userName) {
        return null;
    }

    @Override
    public int count() {
        return userMapper.count();
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateProfile(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }


}
