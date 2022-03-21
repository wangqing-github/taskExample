package com.example.task.example.setting;

import com.example.task.example.entity.BasicAchieveTaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingTaskManager {
    private static final Logger logger = LoggerFactory.getLogger(SettingTaskManager.class);

    private static volatile SettingTaskManager _inst;
    private static final Object _lock = new Object();

    public static SettingTaskManager inst() {
        if (_inst == null) {
            synchronized (_lock) {
                if (_inst == null) _inst = new SettingTaskManager();
            }
        }
        return _inst;
    }

    private SettingTaskManager() {
    }

    public void reloadSetting() {
        reloadTaskSetting();
        logger.info("加载任务相关信息");
    }

    private Map<Integer, List<BasicAchieveTaskEntity>> achieveTaskMap;
    private List<BasicAchieveTaskEntity> achieveTaskList;

    public void reloadTaskSetting() {
        achieveTaskList = new ArrayList<>();
        achieveTaskMap = new HashMap<>();
        for (BasicAchieveTaskEntity basicAllTaskEntity : achieveTaskList) {
            List<BasicAchieveTaskEntity> even = achieveTaskMap.getOrDefault(basicAllTaskEntity.getEvent(), new ArrayList<>());
            even.add(basicAllTaskEntity);
            achieveTaskMap.put(basicAllTaskEntity.getEvent(), even);
        }

    }

    public List<BasicAchieveTaskEntity> getAchieveTaskByEvent(int event) {
        return achieveTaskMap.get(event);
    }


}
