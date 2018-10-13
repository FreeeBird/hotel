package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);
    int insert(User record);
    int insertSelective(User record);
    User selectByPrimaryKey(Integer userId);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);
    User selectByUserNameAndPassword(User user);
    User selectByUserName(String userName);
    int updateByUserNameSelective(User record);
}