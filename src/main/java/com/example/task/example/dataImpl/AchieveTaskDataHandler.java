package com.example.task.example.dataImpl;

import com.example.task.example.TaskCompensationDataHandler;
import com.example.task.example.entity.BasicAchieveTaskEntity;
import com.example.task.example.entity.BasicAllTaskEntity;
import com.example.task.example.entity.UserTaskInfoEntity;
import com.example.task.example.enums.NotifyEnum;
import com.example.task.example.enums.TaskTriggerEnum;
import com.example.task.example.mapper.AchieveTaskMapper;
import com.example.task.example.setting.SettingTaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.example.task.example.enums.TaskTriggerEnum.Achieve_TASK;

@Service
public class AchieveTaskDataHandler implements TaskCompensationDataHandler<UserTaskInfoEntity> {

    @Autowired
    private AchieveTaskMapper achieveTaskMapper;

    @Override
    public boolean isTrigger(String uid, int event) {
        //判断触发
        return true;
    }

    @Override
    public Map<Integer, BasicAllTaskEntity> getConfigTaskInfo(int event, String roleId) {
        List<BasicAchieveTaskEntity> taskList = SettingTaskManager.inst().getAchieveTaskByEvent(event);
        if (taskList == null) {
            ////抛异常什么的。。。
        }
        return taskList.stream().collect(Collectors.toMap(BasicAchieveTaskEntity::getTaskid, Function.identity()));
    }

    @Override
    public Map<Integer, UserTaskInfoEntity> getUnfinishedTasks(int event, String roleId) {
        //去对应的数据表查询未完成的任务
        String tableName = "user_achieve_task_1";
        List<UserTaskInfoEntity> list = achieveTaskMapper.getAllTaskByEvent(tableName, event, roleId);
        return list.stream().collect(Collectors.toMap(UserTaskInfoEntity::getTaskid, Function.identity()));
    }

    @Override
    public void updateUserTasks(List<UserTaskInfoEntity> updateTasks, String roleId) {
        //将修改后的数据更新到对应的数据库中
        String tableName = "user_achieve_task_1";
        if (CollectionUtils.isEmpty(updateTasks)) return;
        achieveTaskMapper.updateUserTaskInfo(tableName, updateTasks);
    }

    @Override
    public NotifyEnum getNotifyEnum() {
        return NotifyEnum.ACHIEVE_COMPLETE;
    }

    @Override
    public TaskTriggerEnum getTriggerEnum() {
        return Achieve_TASK;
    }
}
