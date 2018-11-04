package cn.mafangui.hotel.service;

import cn.mafangui.hotel.entity.Worker;

import java.util.List;

public interface WorkerService {

    int addWorker(Worker worker);
    int delWorker(String userName);
    int updateWorker(Worker worker);
    Worker selectWorker(String userName);
    List<Worker> findAllWorker();
    Worker login(Worker worker);
    int logout(Worker worker);

}
