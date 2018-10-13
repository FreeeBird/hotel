package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.RoomType;

public interface RoomTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    RoomType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);
}