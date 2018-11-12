package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int count();

    List<User> selectAll();

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


}