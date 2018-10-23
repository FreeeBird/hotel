package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.Room;

import java.util.List;


public interface RoomService {
    int addRoom(Room room);
    int deleteRoom(int roomId);
    int deleteRoom(String roomNumber);
    int updateRoom(Room room);
    Room findById(int roomId);
    Room findByNumber(String roomNumber);
    List<Room> findByStatus(String status);
    List<Room> findByType(String typeName);
    List<Room> findAll();
}
