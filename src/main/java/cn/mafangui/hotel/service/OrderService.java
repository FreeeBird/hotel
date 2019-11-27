package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.Order;

import java.util.List;

public interface OrderService {

    int insert(Order order);

    int addOrder(Order order);

    int delete(Integer orderId);

    Order selectById(Integer orderId);

    Order selectByNameAndPhone(String name,String phone);

    int update(Order record);

    int payOrder(int orderId);

    int cancelOrder(int orderId);

    Integer getOrderCount();

    List<Order> selectByUserId(int userId);

    List<Order> AllOrders();

    List<Order> UsersAllOrders(int userId);
}
