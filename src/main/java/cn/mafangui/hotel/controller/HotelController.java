package cn.mafangui.hotel.controller;


import cn.mafangui.hotel.entity.Hotel;
import cn.mafangui.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hotelInfo")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    /**
     * 添加酒店信息
     * @param hotelName
     * @param phone
     * @param telephone
     * @param email
     * @param address
     * @param website
     * @return
     */
    @RequestMapping(value = "/add")
    public int addHotel(String hotelName,String phone,String telephone,String email,String address,String website){
        int result = 0;
        Hotel hotel = new Hotel(hotelName,phone,telephone,email,address,website);
        try {
            result = hotelService.addHotel(hotel);
        }catch (Exception e){
            result = -1;
        }
        return result;
    }

    /**
     * 删除酒店信息
     * @param hotelId
     * @return
     */
    @RequestMapping(value = "/delete")
    public int deleteHotel(int hotelId){
        int result = 0;
        try {
            result = hotelService.deleteHotel(hotelId);
        }catch (Exception e){
            result = -1;
        }
        return result;
    }

    /**
     * 更改酒店信息
     * @param hotelName
     * @param phone
     * @param telephone
     * @param email
     * @param address
     * @param website
     * @return
     */
    @RequestMapping(value = "/update")
    public int updateHotel(int hotelId,String hotelName,String phone,String telephone,String email,String address,String website){
        int result = 0;
        Hotel hotel = new Hotel(hotelName,phone,telephone,email,address,website);
        hotel.setHotelId(hotelId);
        try{
            result = hotelService.updateHotel(hotel);
        }catch (Exception e){
            result = -1;
        }
        return result;
    }

    /**
     * 根据id查询
     * @param hotelId
     * @return
     */
    @RequestMapping(value = "/withId")
    public Hotel selectHotel(int hotelId){
        try {
            return hotelService.selectHotelById(hotelId);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 根据酒店名查询
     * @param hotelName
     * @return
     */
    @RequestMapping(value = "/withName")
    public Hotel selectHotel(String hotelName){
        try {
            return hotelService.selectHotelByName(hotelName);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 所有酒店信息
     * @return
     */
    @RequestMapping(value = "/all")
    public List<Hotel> allHotel(){
        return hotelService.findAllHotel();
    }
}
