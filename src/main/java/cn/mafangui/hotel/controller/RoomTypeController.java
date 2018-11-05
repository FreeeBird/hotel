package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.RoomType;
import cn.mafangui.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/roomType")
public class RoomTypeController {
    private final String CODE = "code";
    private final String DATA = "data";

    @Autowired
    private RoomTypeService roomTypeService;

    /**
     * 添加房间类型
     * @param roomType
     * @param typeName
     * @param bookingPrice
     * @param bookingDiscount
     * @param remark
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public HashMap addNewType(int roomType,String typeName,double bookingPrice,double bookingDiscount,String remark){
        HashMap result = new HashMap();
        result.put(CODE,20000);
        RoomType rt = new RoomType(roomType,typeName,bookingPrice,bookingDiscount,remark);
        result.put(DATA,roomTypeService.addRoomType(rt));
        return result;
    }

    /**
     * 根据id
     * 删除房间类型
     * @param typeId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/del")
    public HashMap delType(int typeId){
        HashMap result = new HashMap();
        result.put(CODE,20000);
        result.put(DATA,roomTypeService.delById(typeId));
        return result;
    }

    public HashMap massDeletion(int[] typeId){
        HashMap result = new HashMap();
        result.put(CODE,20000);
        return result;
    }

    /**
     * 更改房间类型
     * @param roomType
     * @param typeName
     * @param bookingPrice
     * @param bookingDiscount
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public HashMap updateType(int typeId,int roomType,String typeName,double bookingPrice,double bookingDiscount,String remark){
        HashMap result = new HashMap();
        result.put(CODE,20000);
        RoomType rt = new RoomType(roomType,typeName,bookingPrice,bookingDiscount,remark);
        rt.setTypeId(typeId);
        result.put(DATA,roomTypeService.updateRoomType(rt));
        return result;
    }

    /**
     * 查询房间类型
     * @param typeId
     * @return
     */
    @RequestMapping(value = "/withId")
    public HashMap findByRoomType(int typeId){
        HashMap result = new HashMap();
        result.put(CODE,20000);
        result.put(DATA, roomTypeService.selectById(typeId));
        return result;
    }

    /**
     * 查询所有房间类型
     * @return
     */
    @RequestMapping(value = "/all")
    public HashMap findAllRoomType(){
        HashMap result = new HashMap();
        result.put("code",20000);
        result.put("data",roomTypeService.findAllType());
        return result;
    }
}
