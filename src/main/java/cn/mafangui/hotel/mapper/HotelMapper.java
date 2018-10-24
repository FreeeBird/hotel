package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HotelMapper {
    int deleteByPrimaryKey(Integer hotelId);

    int updateByPrimaryKey(Hotel record);

    int insert(Hotel record);
    int insertSelective(Hotel record);
    int updateByPrimaryKeySelective(Hotel record);
    Hotel selectByPrimaryKey(Integer hotelId);
    Hotel selectByName(String hotelName);
    List<Hotel> selectAll();
}