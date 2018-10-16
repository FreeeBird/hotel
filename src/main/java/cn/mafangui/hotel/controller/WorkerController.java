package cn.mafangui.hotel.controller;

import cn.mafangui.hotel.entity.Worker;
import cn.mafangui.hotel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public int login(String userName,String password){
        Worker worker = new Worker(userName,password);
        if (workerService.login(worker) !=null ){
            return 1;
        }else {
            return 0;
        }
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public int addWorker(String userName,String password,String workerName,String phone,String email,String address){
        Worker worker = new Worker(userName,password,workerName,phone,email,address);
        return workerService.addWorker(worker);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/del")
    public int delWorker(String userName){
        return workerService.delWorker(userName);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public int updateWorker(String userName,String password,String workerName,String phone,String email,String address){
        Worker worker = new Worker(userName,password,workerName,phone,email,address);
        return workerService.updateWorker(worker);
    }

    @RequestMapping(value = "/query")
    public Worker queryWorker(String userName){
        return workerService.selectWorker(userName);
    }

    @RequestMapping(value = "/all")
    public List<Worker> findAllWorkers(){
        return workerService.findAllWorker();
    }

}
