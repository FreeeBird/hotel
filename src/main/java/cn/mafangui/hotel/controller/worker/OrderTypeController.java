package cn.mafangui.hotel.controller.worker;

import cn.mafangui.hotel.entity.OrderType;
import cn.mafangui.hotel.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orderType")
public class OrderTypeController {
    @Autowired
    private OrderTypeService orderTypeService;

    @RequestMapping(value = "/add")
    public int addOrderType(String type,String remark){
        OrderType orderType = new OrderType(type,remark);
        return orderTypeService.insertOrderType(orderType);
    }

    @RequestMapping(value = "/delete")
    public int deleteOrderType(int typeId){
        return orderTypeService.deleteOrderType(typeId);
    }

    @RequestMapping(value = "/update")
    public int updateOrderType(int typeId,String type,String remark){
        OrderType orderType = new OrderType(type,remark);
        orderType.setTypeId(typeId);
        return orderTypeService.updateOrderType(orderType);
    }

    @RequestMapping(value = "/withId")
    public OrderType getById(int typeId){
        return orderTypeService.selectById(typeId);
    }

    @RequestMapping(value = "all")
    public List<OrderType> getAllType(){
        return orderTypeService.selectAll();
    }

}
