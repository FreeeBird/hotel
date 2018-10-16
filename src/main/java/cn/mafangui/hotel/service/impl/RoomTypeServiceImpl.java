package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.RoomType;
import cn.mafangui.hotel.mapper.RoomTypeMapper;
import cn.mafangui.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Override
    public int addRoomType(RoomType roomType) {
        return roomTypeMapper.insertSelective(roomType);
    }

    @Override
    public int delRoomType(RoomType roomType) {
        return roomTypeMapper.deleteByRoomType(roomType);
    }

    @Override
    public int updateRoomType(RoomType roomType) {
        return roomTypeMapper.updateByRoomTypeSelective(roomType);
    }

    @Override
    public RoomType selectByName(RoomType roomType) {
        return roomTypeMapper.selectByRoomType(roomType);
    }

    @Override
    public List<RoomType> findAllType() {
        return roomTypeMapper.findAll();
    }
}
