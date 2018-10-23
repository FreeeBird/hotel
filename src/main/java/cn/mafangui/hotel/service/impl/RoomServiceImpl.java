package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.Room;
import cn.mafangui.hotel.mapper.RoomMapper;
import cn.mafangui.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public int addRoom(Room room) {
        return roomMapper.insert(room);
    }

    @Override
    public int deleteRoom(int roomId) {
        return roomMapper.deleteByPrimaryKey(roomId);
    }

    @Override
    public int deleteRoom(String roomNumber) {
        return roomMapper.deleteByRoomNumber(roomNumber);
    }

    @Override
    public int updateRoom(Room room) {
        return roomMapper.updateByPrimaryKeySelective(room);
    }

    @Override
    public Room findById(int roomId) {
        return roomMapper.selectByPrimaryKey(roomId);
    }

    @Override
    public Room findByNumber(String roomNumber) {
        return roomMapper.selectByRoomNumber(roomNumber);
    }

    @Override
    public List<Room> findByStatus(String status) {
        return roomMapper.selectByStatus(status);
    }

    @Override
    public List<Room> findByType(String typeName) {
        return roomMapper.selectByType(typeName);
    }

    @Override
    public List<Room> findAll() {
        return roomMapper.selectAllRoom();
    }
}
