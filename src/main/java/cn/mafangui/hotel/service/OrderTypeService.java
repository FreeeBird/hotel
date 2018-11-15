package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.OrderType;

import java.util.List;

public interface OrderTypeService {

    int insertOrderType(OrderType orderType);

    int deleteOrderType(int typeId);

    int updateOrderType(OrderType orderType);

    OrderType selectById(int typeId);

    List<OrderType> selectAll();
}
