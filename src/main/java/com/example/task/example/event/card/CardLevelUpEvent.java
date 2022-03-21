package com.example.task.example.event.card;


import com.example.task.example.TaskEventChange;
import com.example.task.example.enums.TaskEventEnum;

/**
 * 将a种b品质卡升到c级
 */
public class CardLevelUpEvent extends TaskEventChange {
    private final String roleId;
    /**
     * 数量
     */
    private final int num;
    /**
     * 品质
     */
    private final int type;
    /**
     * 等级
     */
    private final int level;

    public CardLevelUpEvent(Object source, String roleId, int num, int type,int level) {
        super(source);
        this.roleId = roleId;
        this.num = num;
        this.type = type;
        this.level = level;
        addChangeEvent(this);
    }


    @Override
    public int getEvent() {
        return TaskEventEnum.CARD_LEVEL_UP.getId();
    }

    @Override
    public String getRoleId() {
        return roleId;
    }

    public int getNum() {
        return num;
    }

    public int getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }
}
