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

    /**
     * 登录
     * @param admin
     * @return
     */
    @Override
    public Admin login(Admin admin) {
        return adminMapper.selectByUserNameAndPassword(admin);
    }

    /**
     * 注册
     * @param admin
     * @return
     */
    @Override
    public int register(Admin admin) {
        return adminMapper.insertSelective(admin);
    }

    /**
     * 根据username查找
     * @param userName
     * @return
     */
    @Override
    public Admin selectByUserName(String userName) {
        Admin result = adminMapper.selectByUserName(userName);
        if (result != null){
            result.setPassword(null);
        }
        return result;
    }

    /**
     * 更新信息
     * @param admin
     * @return
     */
    @Override
    public int updateProfile(Admin admin) {
        return adminMapper.updateByUserNameSelective(admin);
    }

    /**
     * 更改密码
     * @param admin
     * @param newPassword
     * @return
     */
    @Override
    public int updatePassword(Admin admin, String newPassword) {
        int result = 0;
        if(adminMapper.selectByUserNameAndPassword(admin) != null){
            admin.setPassword(newPassword);
            result = adminMapper.updateByUserNameSelective(admin);
        }
        return result;
    }


    /**
     * 列出所有管理员
     * @return
     */
    @Override
    public List<Admin> findAll() {
        List<Admin> result;
        result = adminMapper.findAll();
        for (Admin admin : result) {
            admin.setPassword(null);
        }
        return result;
    }
}
