package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.CheckIn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CheckInMapper {
    Integer getCount();
    int deleteByPrimaryKey(Integer checkInId);

    int insert(CheckIn record);

    int insertSelective(CheckIn record);

    CheckIn selectByPrimaryKey(Integer checkInId);

    CheckIn selectLatestByRoomNumber(String roomNumber);

    int updateByRoomNumber(String roomNumber);

    int checkOut(Integer checkInId);

    int updateByPrimaryKeySelective(CheckIn record);

    int updateByPrimaryKey(CheckIn record);

    List<CheckIn> selectAll();

}
