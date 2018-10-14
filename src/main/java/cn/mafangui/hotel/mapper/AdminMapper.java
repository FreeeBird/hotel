package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.Admin;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);
    int insert(Admin record);
    int insertSelective(Admin record);
    Admin selectByPrimaryKey(Integer adminId);
    int updateByPrimaryKeySelective(Admin record);
    int updateByPrimaryKey(Admin record);
    Admin selectByUserName(String userName);
    Admin selectByUserNameAndPassword(Admin record);
    int updateByUserNameSelective(Admin record);
    List<Admin> findAll();
}