package com.example.task.example.event.friend;


import com.example.task.example.TaskEventChange;
import com.example.task.example.enums.TaskEventEnum;

/**
 * 拥有n个好友
 */
public class FriendAddEvent extends TaskEventChange {
    private final String roleId;
    /**
     * 数量
     */
    private final int num;

    public FriendAddEvent(Object source, String roleId, int num) {
        super(source);
        this.roleId = roleId;
        this.num = num;
        addChangeEvent(this);
    }

    @Override
    public int getEvent() {
        return TaskEventEnum.ADD_FRIEND.getId();
    }

    @Override
    public String getRoleId() {
        return roleId;
    }

    public int getNum() {
        return num;
    }
}
