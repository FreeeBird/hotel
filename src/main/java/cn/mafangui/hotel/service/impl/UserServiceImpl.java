package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.User;
import cn.mafangui.hotel.mapper.UserMapper;
import cn.mafangui.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userMapper.insert(user);
    }

    @Override
    public User login(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return userMapper.selectByUserNameAndPassword(user);
    }


}
