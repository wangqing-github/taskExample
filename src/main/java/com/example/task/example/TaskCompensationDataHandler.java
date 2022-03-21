package com.example.task.example;

import com.example.task.example.entity.BasicAllTaskEntity;
import com.example.task.example.entity.UserTaskInfoEntity;
import com.example.task.example.enums.NotifyEnum;
import com.example.task.example.enums.TaskTriggerEnum;

import java.util.List;
import java.util.Map;

public interface TaskCompensationDataHandler<T extends UserTaskInfoEntity> {

    /**
     * 此方法预留，做单独处理的时候修改
     */
    TaskTriggerEnum getTriggerEnum();

    /**
     * 此方法可用于特殊判断,根据活动类型，limit等等
     * @return
     */
    boolean isTrigger(String roleId, int event);


    Map<Integer, BasicAllTaskEntity> getConfigTaskInfo(int event, String roleId);

    Map<Integer, UserTaskInfoEntity> getUnfinishedTasks(int event, String uid);

    void updateUserTasks(List<UserTaskInfoEntity> updateTasks,String uid);

    NotifyEnum getNotifyEnum();
}
