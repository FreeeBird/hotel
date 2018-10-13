package cn.mafangui.hotel.mapper;

import cn.mafangui.hotel.entity.Worker;

public interface WorkerMapper {
    int deleteByPrimaryKey(Integer workerId);

    int insert(Worker record);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(Integer workerId);

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);
}