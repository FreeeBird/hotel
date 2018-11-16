package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.Order;

import java.util.List;

public interface OrderService {

    int insert(Order order);

    int delete(Integer orderId);

    Order selectById(Integer orderId);

    int update(Order record);

    List<Order> selectByUserId(int userId);

    List<Order> selectAll();
}
