package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    int addHotel(Hotel hotel);
    int deleteHotel(int hotelId);
    int updateHotel(Hotel hotel);
    Hotel selectHotelByName(String hotelName);
    Hotel selectHotelById(int hotelId);
    List<Hotel> findAllHotel();

}
