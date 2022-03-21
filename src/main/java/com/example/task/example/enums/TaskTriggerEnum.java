package com.example.task.example.enums;

public enum TaskTriggerEnum {
    ERROR(0, "未知类型"),
    NORMAL_TASK(1, "日常任务"),
    STAGE_TASK(2, "阶段任务"),
    Achieve_TASK(3, "成就任务"),
    HELP_CALL_TASK(4, "援军召唤");
    private final int id;
    private final String note;

    TaskTriggerEnum(int id, String note) {
        this.id = id;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public static TaskTriggerEnum getTaskById(int taskCategory) {
        TaskTriggerEnum[] compensationEnums = TaskTriggerEnum.values();
        for (TaskTriggerEnum compensationEnum : compensationEnums) {
            if (compensationEnum.id == taskCategory) return compensationEnum;
        }
        return ERROR;
    }
}
