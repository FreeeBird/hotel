package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.Room;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface RoomMapper {
    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(Integer roomId);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    List<Room> selectByType(Integer typeId);

    List<Room> selectByStatus(Integer roomStatus);

    List<Room> selectAll();

    Room randomSelectByTypeAndStatus(Integer typeId,Integer roomStatus);
}
