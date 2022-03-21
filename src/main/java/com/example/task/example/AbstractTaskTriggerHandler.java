package com.example.task.example;

import com.example.task.example.context.SpringContext;
import com.example.task.example.entity.BasicAllTaskEntity;
import com.example.task.example.entity.UserTaskInfoEntity;
import com.example.task.example.enums.TaskEventEnum;
import com.example.task.example.enums.TaskTriggerEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public abstract class AbstractTaskTriggerHandler {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractTaskTriggerHandler.class);
    private static final Map<TaskTriggerEnum, TaskCompensationDataHandler> dataHandlerRegistry = new HashMap<>();
    private static final Map<Integer, AbstractTaskTriggerHandler> resolveHandlerRegistry = new HashMap<>();

    private static final ExecutorService executor = Executors.newFixedThreadPool(20, new ThreadFactory() {
        private final AtomicInteger atomicInteger = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, "Task-Cal-" + atomicInteger.getAndIncrement());
            thread.setUncaughtExceptionHandler((Thread t, Throwable e) -> logger.error("该错误发生在子线程中", e));
            return thread;
        }
    });

    public static void initTaskHandler() {
        Map<String, TaskCompensationDataHandler> dataHandlers = SpringContext.inst().getInterfaceBeans(TaskCompensationDataHandler.class);
        for (TaskCompensationDataHandler dataHandler : dataHandlers.values()) {
            TaskTriggerEnum compensationEnum = dataHandler.getTriggerEnum();
            dataHandlerRegistry.put(compensationEnum, dataHandler);
        }
        Map<String, AbstractTaskTriggerHandler> resolveBeans = SpringContext.inst().getInterfaceBeans(AbstractTaskTriggerHandler.class);
        for (AbstractTaskTriggerHandler resolveBean : resolveBeans.values()) {
            TaskEventEnum taskEventEnum = resolveBean.getTaskEventEnum();
            resolveHandlerRegistry.put(taskEventEnum.getId(), resolveBean);
        }
    }

    public abstract TaskEventEnum getTaskEventEnum();

    public static void triggerTask(int event, final TaskEventChange applicationEvent) {
        for (TaskCompensationDataHandler dataHandler : dataHandlerRegistry.values()) {
            if (dataHandler == null) {
                continue;
            }
            //这个判断，是判断此数据源类型是否触发，具体判断写在dataImpl实现类里面
            if (!dataHandler.isTrigger(applicationEvent.getRoleId(), event)) {
                continue;
            }
            AbstractTaskTriggerHandler triggerHandler = resolveHandlerRegistry.get(event);
            if (triggerHandler == null) {
                continue;
            }
            executor.execute(() -> {
                String roleId = applicationEvent.getRoleId();
                Map<Integer, BasicAllTaskEntity> configTaskInfo = dataHandler.getConfigTaskInfo(event, roleId);
                Map<Integer, UserTaskInfoEntity> unfinishedTasks = dataHandler.getUnfinishedTasks(event, roleId);
                triggerHandler.initData();
                List<UserTaskInfoEntity> updateTasks = triggerHandler.handleProcess(roleId, configTaskInfo, unfinishedTasks, applicationEvent);
                dataHandler.updateUserTasks(updateTasks, roleId);
            });
        }
    }

    protected List<UserTaskInfoEntity> handleProcess(String roleId, Map<Integer, BasicAllTaskEntity> configTaskInfo
            , Map<Integer, UserTaskInfoEntity> unfinishedTasks, TaskEventChange applicationEvent) {
        List<UserTaskInfoEntity> results = new ArrayList<>();
        for (BasicAllTaskEntity basicAllTaskEntity : configTaskInfo.values()) {
            UserTaskInfoEntity unfinishedTask = unfinishedTasks.get(basicAllTaskEntity.getTaskid());
            if (isTrigger(basicAllTaskEntity, applicationEvent)) {
                calibrateTask(roleId, unfinishedTask, basicAllTaskEntity, applicationEvent);
                results.add(unfinishedTask);
            }
        }
        return results;
    }

    protected abstract void calibrateTask(String uid, UserTaskInfoEntity unfinishedTask, BasicAllTaskEntity taskDetail, TaskEventChange taskEventChange);

    protected boolean isTrigger(BasicAllTaskEntity basicTaskInfo, TaskEventChange taskEventChange) {
        return true;
    }

    protected void initData() {
    }
}
