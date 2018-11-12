package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.Room;

import java.util.List;


public interface RoomService {
    int insert(Room room);
    int delete(int roomId);
    int update(Room room);
    Room selectById(int roomId);
    List<Room> selectByStatus(int roomStatus);
    List<Room> selectByType(int typeId);
    List<Room> selectAll();
}
