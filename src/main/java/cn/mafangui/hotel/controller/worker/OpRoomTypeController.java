package cn.mafangui.hotel.controller.worker;

import cn.mafangui.hotel.entity.RoomType;
import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.ResponseTool;
import cn.mafangui.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/op/room-type")
public class OpRoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;


    /**
     * 所有房型
     * @return
     */
    @RequestMapping(value = "")
    public AjaxResult getAllRoomType(){
        List<RoomType> rooms = roomTypeService.findAllType();
        return ResponseTool.success(rooms);
    }

    /**
     * 查找有余量的房型
     * @return
     */
    @RequestMapping(value = "/rest")
    public AjaxResult findAllRestRoomType(){
        return ResponseTool.success(roomTypeService.findAllRestType());
    }

    /**
     * 根据id查找房型
     * @param typeId
     * @return
     */
    @RequestMapping(value = "/{typeId}")
    public AjaxResult getById(@PathVariable int typeId){
        return ResponseTool.success(roomTypeService.selectById(typeId));
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
    public AjaxResult addRoomType(String roomType,Double price,Double discount,Integer area,
                           Integer bedNum,String bedSize,Integer window,String remark,Integer rest){
        RoomType rt = new RoomType(roomType,remark,price,discount,area,bedNum,bedSize,window);
        rt.setRest(rest);
        int result = roomTypeService.insert(rt);
        if(result!=1) return ResponseTool.failed("添加失败");
        return ResponseTool.success("添加成功");
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
    public AjaxResult updateRoomType(Integer typeId,String roomType,Double price,Double discount,Integer area,
                                     Integer bedNum,String bedSize,Integer window,Integer rest,String remark){
        RoomType rt = new RoomType(roomType,remark,price,discount,area,bedNum,bedSize,window);
        rt.setTypeId(typeId);
        rt.setRest(rest);
        int result = roomTypeService.update(rt);
        if(result!=1) return ResponseTool.failed("修改失败");
        return ResponseTool.success("修改成功");
    }

    /**
     * 删除房型
     * @param typeId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/delete/{typeId}")
    public AjaxResult deleteRoomType(@PathVariable Integer typeId){
        int result = roomTypeService.delete(typeId);
        if(result!=1) return ResponseTool.failed("删除失败");
        return ResponseTool.success("删除成功");
    }



}
