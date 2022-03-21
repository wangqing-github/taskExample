package com.example.task.example.event.user;


import com.example.task.example.TaskEventChange;
import com.example.task.example.enums.TaskEventEnum;

/**
 * 收集n金币
 */
public class CollectCoinEvent extends TaskEventChange {
    private final String roleId;
    /**
     * 数量
     */
    private final int num;

    public CollectCoinEvent(Object source, String roleId, int num) {
        super(source);
        this.roleId = roleId;
        this.num = num;
        addChangeEvent(this);
    }

    @Override
    public int getEvent() {
        return TaskEventEnum.COLLECT_COIN.getId();
    }

    public String getRoleId() {
        return roleId;
    }

    public int getNum() {
        return num;
    }

}
