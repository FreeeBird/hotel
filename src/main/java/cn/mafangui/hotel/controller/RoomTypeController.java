package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.RoomType;
import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.ResponseUtil;
import cn.mafangui.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/roomType")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;


    /**
     * 所有房型
     * @return
     */
    @RequestMapping(value = "")
    public AjaxResult getAllRoomType(){
        List<RoomType> rooms = roomTypeService.findAllType();
        return ResponseUtil.success(rooms);
    }

    /**
     * 根据id查找房型
     * @param typeId
     * @return
     */
    @RequestMapping(value = "/withId")
    public RoomType getById(int typeId){
        return roomTypeService.selectById(typeId);
    }


    /**
     * 添加房型
     * @param roomType
     * @param price
     * @param discount
     * @param area
     * @param bedNum
     * @param bedSize
     * @param window
     * @param remark
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public int addRoomType(String roomType,Double price,Double discount,int area,
                           int bedNum,String bedSize,int window,String remark){
        RoomType rt = new RoomType(roomType,remark,price,discount,area,bedNum,bedSize,window);
        rt.setRest(0);
        int result = 0;
        result = roomTypeService.insert(rt);
        return result;
    }

    /**
     * 修改房型
     * @param typeId
     * @param roomType
     * @param price
     * @param discount
     * @param area
     * @param bedNum
     * @param bedSize
     * @param window
     * @param rest
     * @param remark
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public int updateRoomType(int typeId,String roomType,Double price,Double discount,int area,
                           int bedNum,String bedSize,int window,int rest,String remark){
        RoomType rt = new RoomType(roomType,remark,price,discount,area,bedNum,bedSize,window);
        rt.setTypeId(typeId);
        rt.setRest(rest);
        int result = 0;
        result = roomTypeService.update(rt);
        return result;
    }

    /**
     * 删除房型
     * @param typeId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/delete")
    public int deleteRoomType(int typeId){
        int result = 0;
        result = roomTypeService.delete(typeId);
        return result;
    }

    /**
     * 查找有余量的房型
     * @return
     */
    @RequestMapping(value = "/restAll")
    public List<RoomType> findAllRestRoomType(){
        return roomTypeService.findAllRestType();
    }

}
