package com.example.task.example.taskImpl.user;

import com.example.task.example.AbstractTaskTriggerHandler;
import com.example.task.example.TaskEventChange;
import com.example.task.example.entity.BasicAllTaskEntity;
import com.example.task.example.entity.UserTaskInfoEntity;
import com.example.task.example.enums.TaskEventEnum;
import com.example.task.example.event.user.RoleLevelUpEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Service
@Scope(SCOPE_PROTOTYPE)
public class UserLevelTaskHandler extends AbstractTaskTriggerHandler {
    @Override
    public TaskEventEnum getTaskEventEnum() {
        return TaskEventEnum.USER_LEVEL_UP;
    }

    @Override
    protected void calibrateTask(String roleId, UserTaskInfoEntity unfinishedTask, BasicAllTaskEntity basicAllTaskEntity, TaskEventChange applicationEvent) {
        RoleLevelUpEvent roleLevelUpEvent = (RoleLevelUpEvent) applicationEvent;
        boolean complete = roleLevelUpEvent.getNewLevel() >= basicAllTaskEntity.getCond1();
        if (complete) {
            unfinishedTask.setStatus(1);
            unfinishedTask.setProgress(basicAllTaskEntity.getCond1());
        } else {
            unfinishedTask.setStatus(0);
            unfinishedTask.setProgress(roleLevelUpEvent.getNewLevel());
        }
    }
}
