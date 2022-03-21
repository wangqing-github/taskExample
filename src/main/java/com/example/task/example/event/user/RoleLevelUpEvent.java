package com.example.task.example.event.user;

import com.example.task.example.TaskEventChange;
import com.example.task.example.enums.TaskEventEnum;

/**
 * 玩家升级
 */
public class RoleLevelUpEvent extends TaskEventChange {
    private final String roleId;
    /**
     * 升了多少级
     */
    private final int level;
    /**
     * 新等级
     */
    private final int newLevel;

    public RoleLevelUpEvent(Object source, String roleId, int level,int newLevel) {
        super(source);
        this.roleId = roleId;
        this.level = level;
        this.newLevel = newLevel;
        addChangeEvent(this);
    }

    public int getNewLevel() {
        return newLevel;
    }

    @Override
    public int getEvent() {
        return TaskEventEnum.USER_LEVEL_UP.getId();
    }

    public String getRoleId() {
        return roleId;
    }

    public int getLevel() {
        return level;
    }
}
