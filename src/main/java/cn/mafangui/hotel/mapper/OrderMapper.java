package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.Order;
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

    List<Order> selectAllByUser(Integer userId,Integer orderStatus);


}
