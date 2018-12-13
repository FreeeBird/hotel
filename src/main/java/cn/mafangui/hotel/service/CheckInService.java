package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.CheckIn;

import java.util.HashMap;
import java.util.List;

public interface CheckInService {

    int insert(CheckIn checkIn);

    HashMap checkIn(CheckIn checkIn);

    int delete(int checkInId);

    int update(CheckIn checkIn);

    int checkOut(String roomNumber) throws Exception;

    int updateByRoomNumber(String roomNumber);

    CheckIn selectById(int checkInId);

    List<CheckIn> selectAll();

}
