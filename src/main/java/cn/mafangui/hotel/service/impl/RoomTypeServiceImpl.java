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
    public int insert(RoomType roomType) {
        return roomTypeMapper.insertSelective(roomType);
    }

    @Override
    public int delete(int typeId) {
        return roomTypeMapper.deleteByPrimaryKey(typeId);
    }

    @Override
    public int update(RoomType roomType) {
        return roomTypeMapper.updateByPrimaryKeySelective(roomType);
    }

    @Override
    public RoomType selectByName(String roomType) {
        return roomTypeMapper.selectByRoomType(roomType);
    }

    @Override
    public RoomType selectById(int typeId) {
        return roomTypeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public List<RoomType> findAllType() {
        return roomTypeMapper.selectAll();
    }
}
