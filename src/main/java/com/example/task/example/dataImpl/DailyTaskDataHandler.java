package com.example.task.example.dataImpl;

import com.example.task.example.TaskCompensationDataHandler;
import com.example.task.example.entity.BasicAllTaskEntity;
import com.example.task.example.entity.UserTaskInfoEntity;
import com.example.task.example.enums.NotifyEnum;
import com.example.task.example.enums.TaskTriggerEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.task.example.enums.TaskTriggerEnum.NORMAL_TASK;

@Service
public class DailyTaskDataHandler implements TaskCompensationDataHandler<UserTaskInfoEntity> {


    @Override
    public boolean isTrigger(String roleId, int event) {
        return true;
    }

    @Override
    public Map<Integer, BasicAllTaskEntity> getConfigTaskInfo(int event, String roleId) {
        return getTaskMap(event);
    }

    @Override
    public Map<Integer, UserTaskInfoEntity> getUnfinishedTasks(int event, String roleId) {
//        String tableName = TableName.getDailyTaskName(roleId);
//        List<UserTaskInfoEntity> list = dailyTaskMapper.getAllTaskByEvent(tableName, event, roleId);
//        return list.stream().collect(Collectors.toMap(UserTaskInfoEntity::getTaskid, Function.identity()));
        return null;
    }

    @Override
    public void updateUserTasks(List<UserTaskInfoEntity> updateTasks, String roleId) {
//        String tableName = TableName.getDailyTaskName(roleId);
//        if (CollectionUtils.isEmpty(updateTasks)) return;
//        dailyTaskMapper.updateUserTaskInfo(updateTasks, tableName);
//        List<Integer> taskIdList = new ArrayList<>();
//        for (UserTaskInfoEntity entity : updateTasks) {
//            if (entity.getStatus() > 0) taskIdList.add(entity.getTaskid());
//        }
//        if (!CollectionUtils.isEmpty(taskIdList)) {
//            ParamsBucket paramsBucket = ParamsBucket.paramsFactory().setZoneId(ApiZoneConfig.ZONE_ID).setRoleid(roleId).create("type", 1).create("user", userInfoService.userCacheInfo(roleId)).create("taskList", taskIdList).build();
//            TaskChangeManager.inst().setStat(STAT.STAT_UPDATE_DAILY_ACTIVE, paramsBucket);
//            TaskChangeManager.inst().notifyStatSourceChange();
//        }
    }

    @Override
    public NotifyEnum getNotifyEnum() {
        return NotifyEnum.DAILY_TASK_COMPLETE;
    }

    @Override
    public TaskTriggerEnum getTriggerEnum() {
        return NORMAL_TASK;
    }

    Map<Integer, BasicAllTaskEntity> getTaskMap(int event) {
//        List<BasicDailyTaskEntity> taskList = SettingTaskManager.inst().getDailyTaskByEvent(event);
//        return taskList.stream().collect(Collectors.toMap(BasicAllTaskEntity::getTaskid, Function.identity()));
        return null;
    }
}
