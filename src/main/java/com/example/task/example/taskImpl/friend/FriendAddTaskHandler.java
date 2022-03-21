package com.example.task.example.taskImpl.friend;


import com.example.task.example.AbstractTaskTriggerHandler;
import com.example.task.example.TaskEventChange;
import com.example.task.example.entity.BasicAllTaskEntity;
import com.example.task.example.entity.UserTaskInfoEntity;
import com.example.task.example.enums.TaskEventEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Service
@Scope(SCOPE_PROTOTYPE)
public class FriendAddTaskHandler extends AbstractTaskTriggerHandler {

    @Override
    public TaskEventEnum getTaskEventEnum() {
        return TaskEventEnum.ADD_FRIEND;
    }

    @Override
    protected void calibrateTask(String roleId, UserTaskInfoEntity unfinishedTask, BasicAllTaskEntity basicAllTaskEntity, TaskEventChange applicationEvent) {

    }
}
