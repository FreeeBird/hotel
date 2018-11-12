package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.RoomType;

public interface RoomTypeMapper {
    int deleteByPrimaryKey(Long typeId);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    RoomType selectByPrimaryKey(Long typeId);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);
}