package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.Room;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoomMapper {

    int insertSelective(Room record);
    Room selectByPrimaryKey(Integer roomId);
    int updateByPrimaryKey(Room record);

    int insert(Room record);
    int deleteByPrimaryKey(Integer roomId);
    int deleteByRoomNumber(String roomNumber);
    int updateByPrimaryKeySelective(Room record);
    Room selectByRoomId(Integer roomId);
    Room selectByRoomNumber(String roomNumber);
    List<Room> selectAllRoom();
    List<Room> selectByType(String typeName);
    List<Room> selectByStatus(String status);

}