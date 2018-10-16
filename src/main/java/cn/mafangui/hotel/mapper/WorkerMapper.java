package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.Worker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WorkerMapper {
    int deleteByPrimaryKey(Integer workerId);

    int insert(Worker record);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(Integer workerId);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);

    int deleteByUserName(String userName);
    int updateByUserNameSelective(Worker record);
    Worker selectByUserName(String userName);
    List<Worker> findAll();
    Worker selectByUserNameAndPassword(Worker worker);
}