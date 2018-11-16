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

    @Autowired
    private CheckInService checkInService;

    @RequestMapping(value = "/add")
    public int addCheckIn(int peo_count, String persons, String ids){
        CheckIn checkIn = new CheckIn();
        checkIn.setPeoCount(peo_count);
        checkIn.setPersons(persons);
        checkIn.setIds(ids);
        checkIn.setCheckInTime(new Date());
        return checkInService.insert(checkIn);
    }

    @RequestMapping(value = "/delete")
    public int deleteCheckIn(int checkId){
        return checkInService.delete(checkId)
    }

    @RequestMapping(value = "/update")
    public int update(int checkId,String roomNumber){
        CheckIn checkIn = new CheckIn();
        checkIn.setCheckInId(checkId);
        checkIn.setRoomNumber(roomNumber);
        return checkInService.update(checkIn);
    }

    @RequestMapping(value = "/checkOut")
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
