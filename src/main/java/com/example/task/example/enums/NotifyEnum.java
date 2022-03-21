package com.example.task.example.enums;

public enum NotifyEnum {
    /**
     * 好友申请
     */
    FRIEND_APPLY(1, "好友申请"),
    /**
     * 任务中心任务完成心跳
     */
    DAILY_TASK_COMPLETE(2, "日常任务完成"),
    /**
     * 阶段任务完成心跳
     */
    STAGE_TASK_COMPLETE(3, "阶段任务完成"),
    /**
     * 成就任务完成心跳
     */
    ACHIEVE_COMPLETE(4, "成就任务完成"),
    ;

    private static final String NOTIFY_JSON = "{\"type\":%s,\"id\":%s}";

    private int type;
    private int id;
    private String note;

    NotifyEnum(int type, String note) {
        this.type = type;
        this.note = note;
        this.id = 0;
    }

    NotifyEnum(int type, int id, String note) {
        this.type = type;
        this.id = id;
        this.note = note;
    }

    public String getType() {
        return String.format(NOTIFY_JSON, type, String.valueOf(id));
    }
}

