package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectAll();

    List<Order> selectByUserId(Integer userId);

    List<Order> selectAllByUser(@Param("userId") Integer userId,@Param("orderStatus") Integer orderStatus);


}
