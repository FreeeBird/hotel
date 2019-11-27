package cn.mafangui.hotel.controller.worker;

import cn.mafangui.hotel.entity.OrderType;
import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.ResponseTool;
import cn.mafangui.hotel.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/op/order-type")
public class OrderTypeController {
    @Autowired
    private OrderTypeService orderTypeService;

    @RequestMapping(value = "/add")
    public int addOrderType(String type,String remark){
        OrderType orderType = new OrderType(type,remark);
        return orderTypeService.insertOrderType(orderType);
    }

    @RequestMapping(value = "/delete")
    public int deleteOrderType(Integer typeId){
        return orderTypeService.deleteOrderType(typeId);
    }

    @RequestMapping(value = "/update")
    public int updateOrderType(Integer typeId,String type,String remark){
        OrderType orderType = new OrderType(type,remark);
        orderType.setTypeId(typeId);
        return orderTypeService.updateOrderType(orderType);
    }

    @RequestMapping(value = "/{typeId}")
    public AjaxResult getById(@PathVariable Integer typeId){
        return ResponseTool.success(orderTypeService.selectById(typeId));
    }

    @RequestMapping(value = "")
    public AjaxResult getAllType(){
        return ResponseTool.success(orderTypeService.selectAll());
    }

}
