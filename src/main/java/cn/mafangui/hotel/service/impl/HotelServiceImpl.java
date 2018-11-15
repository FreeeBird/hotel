package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.Hotel;
import cn.mafangui.hotel.mapper.HotelMapper;
import cn.mafangui.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public int insert(Hotel hotel) {
        return hotelMapper.insertSelective(hotel);
    }

    @Override
    public int delete(int hotelId) {
        return hotelMapper.deleteByPrimaryKey(hotelId);
    }

    @Override
    public int update(Hotel hotel) {
        return hotelMapper.updateByPrimaryKeySelective(hotel);
    }

    @Override
    public Hotel selectByName(String hotelName) {
        return hotelMapper.selectByName(hotelName);
    }

    @Override
    public Hotel selectById(int hotelId) {
        return hotelMapper.selectByPrimaryKey(hotelId);
    }

    @Override
    public List<Hotel> selectAll() {
        return hotelMapper.selectAll();
    }
}
