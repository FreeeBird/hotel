package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.RoomType;

import java.util.List;

public interface RoomTypeService {

    int addRoomType(RoomType roomType);

    int delRoomType(RoomType roomType);

    int updateRoomType(RoomType roomType);

    RoomType selectByName(RoomType roomType);

    List<RoomType> findAllType();
}
