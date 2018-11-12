package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.OrderType;

public interface OrderTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(OrderType record);

    int insertSelective(OrderType record);

    OrderType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(OrderType record);

    int updateByPrimaryKey(OrderType record);
}