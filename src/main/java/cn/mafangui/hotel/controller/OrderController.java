package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Order;
import cn.mafangui.hotel.service.OrderService;
import cn.mafangui.hotel.utils.StaticString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/add")
    public int addOrder(String orderType,int userId, String phone, String roomType,
                        Integer numOfRoom, Date orderDate, Integer orderDays, Integer orderStatus, Double orderCost){
        Order order = new Order(orderType,userId,phone,roomType,orderDate,orderDays,orderStatus,orderCost);
        return orderService.insert(order);
    }

    @RequestMapping(value = "/delete")
    public int deleteOrder(int orderId){
        return orderService.delete(orderId);
    }

    @RequestMapping(value = "/hide")
    public int hideOrder(int orderId){
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderStatus(StaticString.WAS_DELETE);
        return orderService.update(order);
    }

    @RequestMapping(value = "/update")
    public int updateOrder(int orderId,String orderType,String roomType,
                            Date orderDate, Integer orderDays, Integer orderStatus, Double orderCost){
        Order order = new Order(orderType,roomType,orderDate,orderDays,orderStatus,orderCost);
        order.setOrderId(orderId);
        return orderService.update(order);
    }

    @RequestMapping(value = "/all")
    public List<Order> getAllOrder(){
        return orderService.selectAll();
    }

    @RequestMapping(value = "/withUserId")
    public List<Order> getByUser(int userId){
        return orderService.selectByUserId(userId);
    }

    @RequestMapping(value = "/withId")
    public Order getById(int orderId){
        return orderService.selectById(orderId);
    }

}
