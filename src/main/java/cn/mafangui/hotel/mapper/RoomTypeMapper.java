package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.RoomType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoomTypeMapper {
    int deleteByPrimaryKey(Integer typeId);
    int insert(RoomType record);
    RoomType selectByPrimaryKey(Integer typeId);
    int updateByPrimaryKeySelective(RoomType record);
    int updateByPrimaryKey(RoomType record);

    int insertSelective(RoomType record);
    int updateByRoomTypeSelective(RoomType record);
    int deleteByRoomType(RoomType roomType);
    RoomType selectByRoomType(RoomType roomType);
    List<RoomType> findAll();
}