package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void payOrder() {
        int orderId = 19;
        System.out.println(orderService.payOrder(orderId));
    }
}
