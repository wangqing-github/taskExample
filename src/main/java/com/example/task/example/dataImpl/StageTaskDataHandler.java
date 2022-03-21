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

import static com.example.task.example.enums.TaskTriggerEnum.STAGE_TASK;

@Service
public class StageTaskDataHandler implements TaskCompensationDataHandler<UserTaskInfoEntity> {

//    @Autowired
//    private StageTaskService stageTaskService;

    @Override
    public boolean isTrigger(String roleId, int event) {
        return true;
    }

    @Override
    public Map<Integer, BasicAllTaskEntity> getConfigTaskInfo(int event, String roleId) {
//        List<BasicStageTaskEntity> taskList = SettingTaskManager.inst().getStageTaskByEvent(event);
//        Integer taskId = getCurrentTaskId(roleId);
//        taskList = taskList.stream().filter(i -> i.getJudge() == 0 || i.getTaskid() == taskId).collect(Collectors.toList());
//        Map<Integer, BasicAllTaskEntity> taskConfig = new HashMap<>();
//        for (BasicAllTaskEntity taskInfo : taskList) {
//            taskConfig.put(taskInfo.getTaskid(), taskInfo);
//        }
//        return taskConfig;
        return null;
    }

    @Override
    public Map<Integer, UserTaskInfoEntity> getUnfinishedTasks(int event, String roleId) {
//        List<UserTaskInfoEntity> list = stageTaskService.getAllTaskByEvent(event, roleId);
//        return list.stream().collect(Collectors.toMap(UserTaskInfoEntity::getTaskid, Function.identity()));
        return null;
    }

    @Override
    public void updateUserTasks(List<UserTaskInfoEntity> updateTasks, String roleId) {
        //将修改后的数据更新到对应的数据库中
//        stageTaskService.updateUserTaskInfo(updateTasks, roleId);
    }

    @Override
    public NotifyEnum getNotifyEnum() {
        return NotifyEnum.STAGE_TASK_COMPLETE;
    }

    @Override
    public TaskTriggerEnum getTriggerEnum() {
        return STAGE_TASK;
    }

}
