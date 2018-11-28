package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Worker;
import cn.mafangui.hotel.enums.Role;
import cn.mafangui.hotel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/operator")
public class OperatorController {
    @Autowired
    private WorkerService workerService;

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public int login(String username,String password){
        if(workerService.login(username,password, Role.OPERATOR.getValue()) != null)
            return 1;
        else return 0;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/delete")
    public int deleteOperator(int workerId){
        return workerService.delete(workerId);
    }

    @RequestMapping(value = "/all")
    public List<Worker> getAllOperator(){
        return workerService.selectByRole(Role.OPERATOR.getValue());
    }

    @RequestMapping(method = RequestMethod.POST,value = "/withId")
    public Worker getOperator(int workerId){
        return workerService.selectById(workerId);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public int addOperator(String username,String password,String name,String gender,String phone,String email,String address){
        Worker worker = new Worker(username,password,name,gender,phone,email,address);
        worker.setRole(Role.OPERATOR.getValue());
        return workerService.insert(worker);
    }


    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public int updateOperator(int workerId,String name,String gender,String phone,String email,String address){
        Worker worker = new Worker();
        worker.setWorkerId(workerId);
        worker.setName(name);
        worker.setGender(gender);
        worker.setPhone(phone);
        worker.setEmail(email);
        worker.setAddress(address);
        return workerService.updateById(worker);
    }

}
