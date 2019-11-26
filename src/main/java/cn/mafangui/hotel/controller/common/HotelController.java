package cn.mafangui.hotel.controller.common;

import cn.mafangui.hotel.entity.Hotel;
import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.ResponseTool;
import cn.mafangui.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "")
    public AjaxResult getAllHotel(){
        return ResponseTool.success(hotelService.selectAll());
    }
}
