package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Hotel;
import cn.mafangui.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "/add")
    public int addHotel(String hotelName,String phone,String telephone,String email,String address,String website){
        Hotel hotel = new Hotel(hotelName,phone,telephone,email,address,website);
        return hotelService.insert(hotel);
    }

    @RequestMapping(value = "/delete")
    public int deleteHotel(int hotelId){
        return hotelService.delete(hotelId);
    }

    @RequestMapping(value = "/update")
    public int updateHotel(int hotelId,String hotelName,String phone,String telephone,String email,String address,String website){
        Hotel hotel = new Hotel(hotelName,phone,telephone,email,address,website);
        hotel.setHotelId(hotelId);
        return hotelService.update(hotel);
    }

    @RequestMapping(value = "/withId")
    public Hotel getById(int hotelId){
        return hotelService.selectById(hotelId);
    }

    @RequestMapping(value = "/withName")
    public Hotel getById(String hotelName){
        return hotelService.selectByName(hotelName);
    }

    @RequestMapping(value = "/all")
    public List<Hotel> getAllHotel(){
        return hotelService.selectAll();
    }
}
