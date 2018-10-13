package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.CheckIn;

public interface CheckInMapper {
    int deleteByPrimaryKey(Integer checkInId);

    int insert(CheckIn record);

    int insertSelective(CheckIn record);

    CheckIn selectByPrimaryKey(Integer checkInId);

    int updateByPrimaryKeySelective(CheckIn record);

    int updateByPrimaryKey(CheckIn record);
}