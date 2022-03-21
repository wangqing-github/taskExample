package com.example.task.example.manager;

import com.example.task.example.AbstractTaskTriggerHandler;
import com.example.task.example.TaskEventChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskManager {
    private static final Logger logger = LoggerFactory.getLogger(TaskManager.class);
    private static volatile TaskManager _inst;
    private static final Object _lock = new Object();

    public static TaskManager inst() {
        if (_inst == null) {
            synchronized (_lock) {
                if (_inst == null) {
                    _inst = new TaskManager();
                }
            }
        }
        return _inst;
    }

    private TaskManager() {
    }

    public static void triggerTask(int event, TaskEventChange applicationEvent) {
        AbstractTaskTriggerHandler.triggerTask(event, applicationEvent);
    }

}
