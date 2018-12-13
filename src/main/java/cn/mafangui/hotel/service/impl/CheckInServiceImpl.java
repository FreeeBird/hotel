package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.CheckIn;
import cn.mafangui.hotel.entity.Order;
import cn.mafangui.hotel.entity.Room;
import cn.mafangui.hotel.entity.RoomType;
import cn.mafangui.hotel.enums.OrderStatus;
import cn.mafangui.hotel.enums.RoomStatus;
import cn.mafangui.hotel.mapper.CheckInMapper;
import cn.mafangui.hotel.service.CheckInService;
import cn.mafangui.hotel.service.OrderService;
import cn.mafangui.hotel.service.RoomService;
import cn.mafangui.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class CheckInServiceImpl implements CheckInService {
    @Autowired
    private CheckInMapper checkInMapper;
    @Autowired
    private OrderService orderService;
    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private RoomService roomService;

    @Override
    public int insert(CheckIn checkIn) {
        return checkInMapper.insert(checkIn);
    }

    /**
     * 入住登记
     * @param checkIn
     * 1.获取订单
     * 2.获取房间类型
     * 3.获取房间
     * @return
     */
    @Override
    @Transactional
    public HashMap checkIn(CheckIn checkIn) {
        HashMap resultMap = new HashMap();
        int code = 0;
        Order order = orderService.selectById(checkIn.getOrderId());
        RoomType rt = roomTypeService.selectById(order.getRoomTypeId());
        Room r=roomService.selectById(roomService.inRoom(order.getRoomTypeId()));
        if (r == null) code = -3;
        checkIn.setRoomId(r.getRoomId());
        checkIn.setRoomNumber(r.getRoomNumber());
        if (roomTypeService.updateRest(rt.getTypeId(),-1) <= 0) code = -2;
        order.setOrderStatus(OrderStatus.CHECK_IN.getCode());
        if (orderService.update(order) <=0 ) code =  -1;
        code = checkInMapper.insert(checkIn);
        resultMap.put("code",code);
        resultMap.put("room",r);
        return resultMap;
    }

    /**
     * 退房登记
     * 1.获取房间
     * 2.获取房型
     * 3.获取checkIn
     * @param roomNumber
     * @return
     */
    @Override
    public int checkOut(String  roomNumber) throws Exception{
        Room r = roomService.selectByNumber(roomNumber);
        RoomType ty = roomTypeService.selectById(r.getTypeId());
        CheckIn checkIn = checkInMapper.selectLatestByRoomNumber(roomNumber);
        r.setRoomStatus(RoomStatus.AVAILABLE.getCode());
        if(roomService.update(r) <=0 )return -3;
        if (roomTypeService.updateRest(ty.getTypeId(),1)<=0)return -2;
        return checkInMapper.checkOut(checkIn.getCheckInId());
    }

    @Override
    public int delete(int checkInId) {
        return checkInMapper.deleteByPrimaryKey(checkInId);
    }

    @Override
    public int update(CheckIn checkIn) {
        return checkInMapper.updateByPrimaryKeySelective(checkIn);
    }



    @Override
    public int updateByRoomNumber(String roomNumber) {
        return checkInMapper.updateByRoomNumber(roomNumber);
    }

    @Override
    public CheckIn selectById(int checkInId) {
        return checkInMapper.selectByPrimaryKey(checkInId);
    }

    @Override
    public List<CheckIn> selectAll() {
        return checkInMapper.selectAll();
    }
}
