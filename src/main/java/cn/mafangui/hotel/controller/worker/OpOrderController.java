package cn.mafangui.hotel.controller.worker;

import cn.mafangui.hotel.entity.Order;
import cn.mafangui.hotel.enums.OrderStatus;
import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.MsgType;
import cn.mafangui.hotel.response.ResponseTool;
import cn.mafangui.hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 订单接口
 */
@RestController
@RequestMapping(value = "/op/order")
public class OpOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 添加预订
     * 订单状态默认为未付款状态
     */
    @RequestMapping(value = "/add")
    public AjaxResult addOrder(int orderTypeId,String orderType, int userId,String name, String phone,int roomTypeId, String roomType,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") Date orderDate, Integer orderDays, Double orderCost){
        Order order = new Order(orderTypeId,orderType,userId,name,phone,roomTypeId,
                roomType,orderDate,orderDays, OrderStatus.UNPAID.getCode(),orderCost);
        int re = orderService.addOrder(order);
        if(re!=1) return ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success("添加成功.");
    }


    @RequestMapping(value = "/delete")
    public AjaxResult deleteOrder(int orderId){
        int re = orderService.delete(orderId);
        if(re!=1) return ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success("删除成功.");
    }


    @RequestMapping(value = "/update")
    public AjaxResult updateOrder(int orderId,int orderTypeId,String orderType, int userId,String name, String phone,int roomTypeId, String roomType,
                           @DateTimeFormat(pattern = "yyyy-MM-dd") Date orderDate, Integer orderDays, Double orderCost){
        Order order = new Order(orderTypeId,orderType,userId,name,phone,roomTypeId,
                roomType,orderDate,orderDays, OrderStatus.UNPAID.getCode(),orderCost);
        int re =  orderService.update(order);
        if(re!=1) return ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success("修改成功.");
    }

    /**
     * 订单支付
     * @param orderId
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/pay")
    public AjaxResult payOrder(int orderId){
        int re = orderService.payOrder(orderId);
        if(re!=1) return ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success("支付成功.");
    }

    /**
     * 取消订单
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/cancel")
    public AjaxResult cancelOrder(int orderId){
        int re= orderService.cancelOrder(orderId);
        if(re!=1) return ResponseTool.failed(MsgType.FAILED);
        return ResponseTool.success("取消成功.");
    }

    /**
     * 订单超时
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/overtime")
    public int orderOver(int orderId){
        Order order = new Order(orderId,OrderStatus.OVERTIME.getCode());
        return orderService.update(order);
    }


    @RequestMapping(value = "")
    public AjaxResult getAllOrder(){
        return ResponseTool.success(orderService.AllOrders());
    }

    @RequestMapping(value = "/count")
    public AjaxResult getOrderCount(){
        return ResponseTool.success(orderService.getOrderCount());
    }

    /**
     * 根据userID查询所有订单
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}")
    public AjaxResult getByUser(@PathVariable  int userId){
        return ResponseTool.success(orderService.selectByUserId(userId));
    }


    /**
     * 根据订单号查询订单
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/{orderId}")
    public AjaxResult getById(@PathVariable Integer orderId){
        return ResponseTool.success(orderService.selectById(orderId));
    }

    /**
     * 根据姓名、预留手机号查找订单
     * 主要用于客户入住
     * @param name
     * @param phone
     * @return
     */
    @RequestMapping(value = "/withNameAndPhone")
    public AjaxResult getByNameAndPhone(String name,String phone){
        return ResponseTool.success(orderService.selectByNameAndPhone(name,phone));
    }

}
