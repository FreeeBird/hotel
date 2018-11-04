package cn.mafangui.hotel.service.impl;

import cn.mafangui.hotel.entity.Worker;
import cn.mafangui.hotel.mapper.WorkerMapper;
import cn.mafangui.hotel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public int addWorker(Worker worker) {
        return workerMapper.insertSelective(worker);
    }

    @Override
    public int delWorker(String userName) {
        return workerMapper.deleteByUserName(userName);
    }

    @Override
    public int updateWorker(Worker worker) {
        return workerMapper.updateByUserNameSelective(worker);
    }

    @Override
    public Worker selectWorker(String userName) {
        return workerMapper.selectByUserName(userName);
    }

    @Override
    public List<Worker> findAllWorker() {
        return workerMapper.findAll();
    }

    @Override
    public Worker login(Worker worker) {
        return workerMapper.selectByUserNameAndPassword(worker);
    }

    @Override
    public int logout(Worker worker) {
        return 0;
    }
}
