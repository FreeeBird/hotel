package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.CheckIn;
import cn.mafangui.hotel.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/checkIn")
public class CheckInController {

    private final CheckInService checkInService;

    @Autowired
    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    /**
     * 入住登记
     * @param peo_count
     * @param persons
     * @param ids
     * @return
     */
    @RequestMapping(value = "/in")
    public int addCheckIn(int orderId, int peo_count, String persons, String ids){
        CheckIn checkIn = new CheckIn();
        checkIn.setOrderId(orderId);
        checkIn.setPeoCount(peo_count);
        checkIn.setPersons(persons);
        checkIn.setIds(ids);
        return checkInService.insert(checkIn);
    }

    @RequestMapping(value = "/delete")
    public int deleteCheckIn(int checkId){
        return checkInService.delete(checkId);
    }

    @RequestMapping(value = "/update")
    public int update(int checkId,String roomNumber){
        CheckIn checkIn = new CheckIn();
        checkIn.setCheckInId(checkId);
        checkIn.setRoomNumber(roomNumber);
        return checkInService.update(checkIn);
    }

    @RequestMapping(value = "/out")
    public int checkOut(String roomNumber){
        return checkInService.updateByRoomNumber(roomNumber);
    }

    @RequestMapping(value = "/withId")
    public CheckIn getById(int checkId){
        return checkInService.selectById(checkId);
    }

    @RequestMapping(value = "/all")
    public List<CheckIn> getAll(){
        return checkInService.selectAll();
    }

}
