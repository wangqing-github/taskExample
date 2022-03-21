package com.example.task.example.mapper;

import com.example.task.example.entity.UserTaskInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchieveTaskMapper {

    List<UserTaskInfoEntity> getAllTaskByEvent(@Param("tableName")String tableName, @Param("event")int event, @Param("roleId")String roleId);

    void updateUserTaskInfo(@Param("tableName")String tableName,@Param("list")List<UserTaskInfoEntity> userTaskList);

}
